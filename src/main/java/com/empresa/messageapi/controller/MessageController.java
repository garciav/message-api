package com.empresa.messageapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.messageapi.model.Message;
import com.empresa.messageapi.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping(value = "messages")
	public List<Message> findAll() {
		return messageService.findAll();
	}

	@GetMapping(value = "messages/{groupId}")
	public List<Message> findAllMessagesByGroupId(@RequestParam Long groupId) {
		return messageService.findByGroup(groupId);
	}

	@PostMapping(value = "messages")
	public Message newProduct(@RequestBody Message message) {
		return messageService.create(message);
	}
}
