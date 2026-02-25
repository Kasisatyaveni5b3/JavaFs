package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepo;

@Controller
public class AuthController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/auth/register")
    public User registerUser(@RequestBody User user) {

    }
}
