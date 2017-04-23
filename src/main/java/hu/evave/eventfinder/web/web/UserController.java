package hu.evave.eventfinder.web.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.evave.eventfinder.web.model.user.User;
import hu.evave.eventfinder.web.repository.UserRepository;
import hu.evave.eventfinder.web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "/login";
	}
	
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String edit(Map<String, Object> model) {	
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		model.put("user", userRepository.findByName(auth.getName()));
		return "settings";

	}
	
	@RequestMapping(value = "/settings", method = RequestMethod.POST)
	public String edit(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "redirect:/settings";

	}
}
