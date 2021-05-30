package com.car.systems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping()
	@ResponseBody
	public ResponseEntity<User> getUser(@RequestParam Long id) {
		return new ResponseEntity<User>(userService.getUser(id),HttpStatus.CREATED);
	}

	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password) {
		try {
			userService.register(username, password);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("User Succesfulyl registered",HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestParam Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Deleted!",HttpStatus.CREATED);
	}
}
