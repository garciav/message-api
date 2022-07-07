package com.empresa.messageapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.empresa.messageapi.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

}
