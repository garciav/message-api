package com.empresa.messageapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.messageapi.model.Message;
import com.empresa.messageapi.service.MessageService;

@RestController
public class GreetingController {

	@Autowired
	private MessageService messageService;

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Message greeting(Message message) throws Exception {
		return messageService.create(message);
	}
}