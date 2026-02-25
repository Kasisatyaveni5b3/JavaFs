package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepo;
import com.example.springapp.service.UserService;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
       userService.registerUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody String email,String password) {
        String token = userService.LoginUser(email, password);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
