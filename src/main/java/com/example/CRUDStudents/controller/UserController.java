package com.example.CRUDStudents.controller;

import com.example.CRUDStudents.entity.User;
import com.example.CRUDStudents.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user/new")
    public void addUser(@RequestBody User newUser) {
        userService.registerUser(newUser);
    }



}