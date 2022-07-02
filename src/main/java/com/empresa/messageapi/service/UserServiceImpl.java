package com.empresa.messageapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.messageapi.model.User;
import com.empresa.messageapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User create(User user) {
		return userRepository.save(user);
	}
}
