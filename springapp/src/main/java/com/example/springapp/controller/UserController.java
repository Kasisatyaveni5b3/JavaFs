package com.example.springapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/profile")
    public String profile() {
        return "Welcome to User Profile!";
    }
}