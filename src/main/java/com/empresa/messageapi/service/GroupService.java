package com.empresa.messageapi.service;

import com.empresa.messageapi.model.Group;
import com.empresa.messageapi.model.User;

public interface GroupService {

	Group create(Group group);

	Group getGroupByUser(User user);

	Group getGroupByUserId(Long userId);

}