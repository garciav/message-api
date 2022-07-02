package com.empresa.messageapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.empresa.messageapi.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

	List<Message> findByGroup_id(Long groupId);

}
