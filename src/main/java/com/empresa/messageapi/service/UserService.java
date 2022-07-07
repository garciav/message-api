package com.empresa.messageapi.service;

import java.util.List;

import com.empresa.messageapi.model.User;

public interface UserService {

	User findByEmail(String email);
	User create(User user);
	List<User> findAll();
}