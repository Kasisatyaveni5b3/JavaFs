package com.example.springapp;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springapp.service.UserService;
import com.example.springapp.utils.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter) {
       String authenticationHeader = request.getHeader("AUTHORIZATION");
       if(authenticationHeader != null && authenticationHeader.startsWith("Bearer")) {
        String token = authenticationHeader.substring(7);
        if(jwtUtil.validToken(token)) {
            
        }
       }
    }
}
