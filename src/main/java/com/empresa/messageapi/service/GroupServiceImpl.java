package com.empresa.messageapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.messageapi.model.Group;
import com.empresa.messageapi.model.User;
import com.empresa.messageapi.repository.GroupRepository;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public Group create(Group group) {
		return groupRepository.save(group);
	}

	@Override
	public Group getGroupByUser(User user) {
		//TODO: GROUP BY USER
		List<Group> findAll = (List<Group>) groupRepository.findAll();
		return findAll.stream().findFirst().orElse(null);
	}

	@Override
	public Group getGroupByUserId(Long userId) {
		//TODO: GROUP BY USER
		List<Group> findAll = (List<Group>) groupRepository.findAll();
		return findAll.stream().findFirst().orElse(null);
	}
}
