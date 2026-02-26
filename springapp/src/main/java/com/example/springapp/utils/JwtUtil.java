package com.example.springapp.utils;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private String mySecret = "mySuperSecretKey12345678901234567890";
    private long expirationDate = 360000;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(mySecret.getBytes());
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationDate))
                .signWith(getSigningKey()).compact();
    }

    public boolean validToken(String token) {
        try {
            Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).
    }

}
