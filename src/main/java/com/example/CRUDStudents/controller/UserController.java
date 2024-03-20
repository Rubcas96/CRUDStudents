package com.example.CRUDStudents.controller;

import com.example.CRUDStudents.entity.User;
import com.example.CRUDStudents.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<String> registerUser(@RequestBody User newUser) {
        userService.registerUser(newUser);
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/user/info")
    public ResponseEntity<String> getUserInfo(@RequestHeader Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>("Información del usuario: " + user.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}