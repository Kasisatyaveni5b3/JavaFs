package com.example.springapp.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springapp.TodoNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TodoNotFoundException.class);
    public ResponseEntity<Map<String,Object>> handleTodoException(TodoNotFoundException e) {
        
    }
}
