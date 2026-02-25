package com.example.springapp.utils;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureAlgorithm;

@Component
public class JwtUtil {
    private String mySecret="mySuperSecretKey12345678901234567890";
    private String expirationDate="3600000";
    
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(mySecret.getBytes());
    }
    
    public String generateToken(String email) {
       return Jwts.builder()
       .subject(email)
       .issuedAt(new Date())
       .expiration(new Date(System.currentTimeMillis()+expirationDate))
       .signWith(getSigningKey()).compact();
    }
}
