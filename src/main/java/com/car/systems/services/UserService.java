package com.car.systems.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.systems.models.User;
import com.car.systems.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void saveUser(String username, String password) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				userRepository.save(user);
	}
	
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUser(Long id){
		Optional<User> optinalUser =  userRepository.findById(id);
		if(optinalUser.isPresent()) {
			return optinalUser.get();
		}else {
			return null;
		}
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
