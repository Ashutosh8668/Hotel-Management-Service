package com.example.user.service.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.service.UserService.entities.User;

public interface UserRepository extends JpaRepository<User,String>
{
    //if you want to implement any custom method or query
    //write
}
