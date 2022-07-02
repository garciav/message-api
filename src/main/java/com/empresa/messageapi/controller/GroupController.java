package com.empresa.messageapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Group newProduct(@RequestBody Group group) {
		return groupService.create(group);
	}

	@GetMapping(value = "groups/{userId}")
	public Group findGroupByUserId(Long userId) {
		return groupService.getGroupByUserId(userId);
	}
}
