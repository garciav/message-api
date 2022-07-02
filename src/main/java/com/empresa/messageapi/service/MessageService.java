package com.empresa.messageapi.service;

import java.util.List;

import com.empresa.messageapi.model.Message;

public interface MessageService {

	Message create(Message message);

	List<Message> findByGroup(Long groupId);

	List<Message> findAll();

}
