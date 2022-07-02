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
import org.springframework.web.bind.annotation.RestController;

import com.empresa.messageapi.model.Group;
import com.empresa.messageapi.service.GroupService;

@RestController
public class GroupController {

	@Autowired
	private GroupService groupService;

	@PostMapping(value = "groups")
	public ResponseEntity<?> newGroup(@Valid @RequestBody Group group, BindingResult result) {
		HashMap<String, Object> response = new HashMap<>();
        if(result.hasErrors()) {
	        List<String> errores = result.getFieldErrors()
	                .stream()
	                .map(e -> "El atributo: '"+e.getField()+"' contiene errores. "+e.getDefaultMessage()).collect(Collectors.toList());
	        response.put("errors", errores);
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("mensaje", "Grupo creado con exito");
        response.put("grupo", groupService.create(group));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping(value = "groups/{userId}")
	public Group findGroupByUserId(Long userId) {
		return groupService.getGroupByUserId(userId);
	}
}
