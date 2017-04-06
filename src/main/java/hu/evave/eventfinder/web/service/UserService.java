package hu.evave.eventfinder.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.evave.eventfinder.web.model.user.Role;
import hu.evave.eventfinder.web.model.user.User;
import hu.evave.eventfinder.web.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserService() {
	}

	public void save(User user) {
		user.setPassword(user.getPassword());
		user.addRole(Role.ADMIN);
		userRepository.save(user);
	}

	public User login(String email, String password) {
		User user = userRepository.findByEmail(email);

		if (user == null) {
			return null;
		}
		if (!user.getPassword().equals(password)) {
			return null;
		}

		return user;
	}

	public void changePassword(String email, String newPassword) {
		User user = userRepository.findByEmail(email);

		if (user == null) {
			return;
		}

		user.setPassword(newPassword);
		userRepository.save(user);
	}

}
