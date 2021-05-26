package com.car.systems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.systems.models.User;
import com.car.systems.services.UserService;

@Controller()
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	@ResponseBody
	public Iterable<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping()
	@ResponseBody
	public User getUser(@RequestParam Long id) {
		return userService.getUser(id);
	}

	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestParam String username, @RequestParam String password) {
		userService.saveUser(username, password);
		return "User Succesfulyl registered";
	}

	@DeleteMapping()
	public String delete(@RequestParam Long id) {
		userService.deleteUser(id);
		return "Delete!";
	}
}
