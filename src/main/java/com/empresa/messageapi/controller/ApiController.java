package com.empresa.messageapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.messageapi.model.Message;
import com.empresa.messageapi.service.MessageService;

@RestController
public class ApiController {

	@Autowired
	private MessageService messageService;

	@MessageMapping("/message")
	@SendTo("/topic/message")
	public ResponseEntity<?> subscribeMessage(@RequestBody Message message) throws Exception {
		HashMap<String, Object> response = new HashMap<>();

        Message create = messageService.create(message);
        response.put("message", "Mensaje creado con exito");
		response.put("payload", create);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}