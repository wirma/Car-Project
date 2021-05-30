package com.car.systems.services;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.car.systems.models.User;
import com.car.systems.repositories.UserRepository;
import com.google.common.hash.Hashing;

@Service
public class UserService {

	private static final String USER_ROLE = "USER";
	@Autowired
	private UserRepository userRepository;

	public void saveUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(USER_ROLE);
		userRepository.save(user);
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUser(Long id) {
		Optional<User> optinalUser = userRepository.findById(id);
		if (optinalUser.isPresent()) {
			return optinalUser.get();
		} else {
			return null;
		}
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public void register(String username, String password) throws Exception {
		if (findUserByUsername(username) != null) {
			throw new Exception("User already registered!");
		} else {
			saveUser(username, hashPassword(password));
		}

	}

	public User login(String username, String password) throws Exception {
		Optional<User> optinalUser = userRepository.findByUsernameAndPassword(username, hashPassword(password));
		if (!optinalUser.isPresent()) {
			throw new Exception("User not existing!");
		} else {
			return optinalUser.get();
		}
	}

	private String hashPassword(String password) {
		return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
	}

	private User findUserByUsername(String username) {
		Optional<User> optinalUser = userRepository.findByUsername(username);
		if (optinalUser.isPresent()) {
			return optinalUser.get();
		} else {
			return null;
		}
	}
}
