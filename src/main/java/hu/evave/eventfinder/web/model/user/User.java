package hu.evave.eventfinder.web.model.user;

import java.util.List;
import java.util.Set;

import hu.evave.eventfinder.web.model.Event;

public class User {

	private Long id;
	private String name;
	private String email;
	private String password;

	private Set<Role> roles;

	private List<Event> savedEvents;

	public User() {
	}

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public void addRole(Role role) {
		roles.add(role);
	}

	public void saveEvent(Event event) {
		savedEvents.add(event);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

}
