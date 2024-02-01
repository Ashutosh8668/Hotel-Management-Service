package com.example.user.service.UserService.services;

import java.util.List;

import com.example.user.service.UserService.entities.User;

public interface UserService {
	User saveUser(User user);

    //get all user
    List<User> getAllUser();
    
    User getUser(String userId);
}
