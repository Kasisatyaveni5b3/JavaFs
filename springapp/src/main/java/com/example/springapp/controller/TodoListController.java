package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.springapp.model.TodoList;
import com.example.springapp.service.TodoListService;

@RestController
public class TodoListController {
    @Autowired
    TodoListService todoSer;
    @PostMapping("/create")
    public ResponseEntity<TodoList> createtodoList(@RequestBody TodoList todo) {
        try {
           TodoList todolist = todoSer.createTodoList(todo);
           return ResponseEntity.status(HttpStatus.CREATED).body(todolist);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<TodoList>> createtodoList() {
        try {
           List<TodoList> todolist = todoSer.getToDos();
           return ResponseEntity.status(HttpStatus.CREATED).body(todolist);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
