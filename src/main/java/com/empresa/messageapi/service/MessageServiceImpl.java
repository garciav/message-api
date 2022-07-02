package com.empresa.messageapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.messageapi.model.Message;
import com.empresa.messageapi.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public Message create(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public List<Message> findByGroup(Long groupId) {
		return messageRepository.findByGroup_id(groupId);
	}

	@Override
	public List<Message> findAll() {
		return (List<Message>) messageRepository.findAll();
	}
}
