package com.example.springapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import javax.validation.Valid;

import com.example.springapp.model.TodoList;
import com.example.springapp.service.TodoListService;

@RestController
public class TodoListController {
    @Autowired
    TodoListService todoSer;
    public static final Logger logger = LoggerFactory.getLogger(TodoListController.class);
    @PostMapping("/create")
    public ResponseEntity<TodoList> createtodoList(@Valid @RequestBody TodoList todo) {
        TodoList todolist = todoSer.createTodoList(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todolist);
    }

    @GetMapping("/")
    public ResponseEntity<List<TodoList>> createtodoList() {
        List<TodoList> todolist = todoSer.getToDos();
        logger.debug("todolist fetched", todolist);
           return ResponseEntity.ok(todolist);
    }
    
    @GetMapping("/todos/{id}")
    public ResponseEntity<TodoList> getTodosList(@PathVariable int id) {
        TodoList todo=todoSer.getTodosById(id);
        logger.info("string");
        return ResponseEntity.ok(todo);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<TodoList> updatetodoList(@PathVariable int id, @RequestBody TodoList todos) {
        TodoList todolist = todoSer.updateTodos(id,todos);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(todolist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodoList(@PathVariable int id) {
        todoSer.deleteTodo(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }

    @GetMapping("/todos/createdAt")
    public ResponseEntity<List<TodoList>> sorttodoList(@RequestParam OffsetDateTime createdAt) {
        List<TodoList> todolist = todoSer.getToDos();
        return ResponseEntity.status(HttpStatus.CREATED).body(todolist);
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<TodoList>> sorttodoList(@Valid @RequestParam int pageNumber,@RequestParam int pageSize) {
        Page<TodoList> todolist = todoSer.pagination(pageNumber,pageSize);
        return ResponseEntity.ok(todolist);
    }


}
