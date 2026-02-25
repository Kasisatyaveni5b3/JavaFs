package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springapp.SecurityConfig;
import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepo;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordencoder;
    public User registerUser(User user) {
        Optional<User> existingUser = userRepo.findByEmail(user.getEmail())
        if(existingUser.isPresent()) {
            return "user already registered";
        }
        user.setPassword(passwordencoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
