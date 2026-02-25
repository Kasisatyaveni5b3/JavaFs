package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.SecurityConfig;
import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    SecurityConfig securityConfig;
    public String registerUser(User user) {
        if(userRepo.findByUserName(user.getName()).isPresent()) {
            return "user already registered";
        }

        user.setPassword(securityConfig.passwordEncoder.encode(user.getPassword()));
        user.setRole("user");
        userRepo.save(user);
    }
    
}
