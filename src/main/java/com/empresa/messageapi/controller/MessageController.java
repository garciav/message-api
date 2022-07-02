package com.empresa.messageapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<?> newProduct(@Valid @RequestBody Message message, BindingResult result) {
		
		HashMap<String, Object> response = new HashMap<>();
        if(result.hasErrors()) {
	        List<String> errores = result.getFieldErrors()
	                .stream()
	                .map(e -> "El atributo: '"+e.getField()+"' contiene errores. "+e.getDefaultMessage()).collect(Collectors.toList());
	        response.put("errors", errores);
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("mensaje", "Mensaje creado con exito");
        Message create = messageService.create(message);
		response.put("grupo", create);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
