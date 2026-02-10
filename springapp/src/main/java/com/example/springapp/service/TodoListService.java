package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.TodoList;
import com.example.springapp.repository.TodoListRepo;

@Service
public class TodoListService {
    @Autowired
    TodoListRepo todolistRepo;

    public TodoList createTodoList(TodoList todo) {
        return todolistRepo.save(todo);
    }
}
