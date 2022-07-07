package com.empresa.messageapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.messageapi.model.User;
import com.empresa.messageapi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "users")
	public User createUser(@RequestBody User user) {
		return userService.create(user);
	}

	@GetMapping(value = "users")
	public List<User> findAll() {
		return userService.findAll();
	}
}
