package com.example.springapp.utils;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
    private String mySecret="mySuperSecretKey12345678901234567890";
    private String expirationDate="3600000";

    public String signInKey() {
        return 
    }

    public String generateToken(String email) {
        return Jwts.builder().setSubject(email).
    }
}
