package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.service.TodoListService;

@RestController
public class TodoListController {
    @Autowired
    TodoListService todoSer;
    public ResponseEntity<TodoList> createtodoList(@RequestBody TodoList todo) {
        
    }
}
