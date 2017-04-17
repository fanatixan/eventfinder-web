package hu.evave.eventfinder.web;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select name,password,1 from user where name = ?")
				.authoritiesByUsernameQuery("select u.name,r.role FROM user_role r, user u where u.name=? AND u.id=r.user_id");		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().permitAll()
			.and()
			.authorizeRequests()
				.antMatchers("/", "/login").permitAll()
				.and()
			.authorizeRequests()
				.antMatchers("/myevents").authenticated()
				.anyRequest().authenticated()
				.and()
			.authorizeRequests()
				.antMatchers("/events").access("hasAuthority('SUPERADMIN')")
				.anyRequest().authenticated()
				.and()
			.formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/myevents", true)
                .and()
            .logout()
                .permitAll();
	}

	
	
}
