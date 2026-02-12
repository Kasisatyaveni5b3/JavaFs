package com.example.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class SecurityController {
    
    @GetMapping("/public")
    public String publicMethod() {
        return "this is public method";
    }

    @GetMapping("/private")
    public String privateMethod() {
        return "this is private method";
    }
}
