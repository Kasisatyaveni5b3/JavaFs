package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
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

    
    @PutMapping("/update/{id}")
    public ResponseEntity<TodoList> updatetodoList(@PathVariable int id, @RequestBody TodoList todos) {
        try {
           TodoList todolist = todoSer.updateTodos(id,todos);
           return ResponseEntity.status(HttpStatus.ACCEPTED).body(todolist);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodoList(@PathVariable int id) {
    
        todoSer.deleteTodo(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }

    @GetMapping("/todos/createdAt")
    public ResponseEntity<List<TodoList>> sorttodoList(@RequestParam OffsetDateTime createdAt) {
        try {
           List<TodoList> todolist = todoSer.getToDos();
           return ResponseEntity.status(HttpStatus.CREATED).body(todolist);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<TodoList>> sorttodoList(@RequestParam int pageNumber,@RequestParam int pageSize) {
        try {
           Page<TodoList> todolist = todoSer.pagination(pageNumber,pageSize);
           return ResponseEntity.ok(todolist);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
