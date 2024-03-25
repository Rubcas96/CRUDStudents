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
    public ResponseEntity<String> getUserInfo(@RequestParam Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>("Información del usuario: " + user.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/suscribir")
    public ResponseEntity<String> suscribirUsuario(@RequestParam("userId") Long userId) {
        try {
            userService.suscribirUsuario(userId);
            return ResponseEntity.ok("El usuario se ha suscrito correctamente al Boletín Oficial del Estado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al suscribir al usuario al Boletín Oficial del Estado.");
        }
    }

    @DeleteMapping("/user/delete")
    public void deleteUser(@RequestParam Long userId){
        userService.deleteUserById(userId);
    }


    @DeleteMapping("/user/delete/all")
    public void deleteAllUsers(@RequestParam Long userId){
        userService.deleteAllUser();
    }


}