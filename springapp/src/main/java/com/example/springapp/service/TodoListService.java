package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<TodoList> getToDos() {
        return todolistRepo.findAll();
    }

    public TodoList updateTodos(int id, TodoList todos) {
        TodoList todo =todolistRepo.findById(id).orElseThrow();
        todo.setTaskName(todos.getTaskName());
        todo.setTaskDescription(todos.getTaskDescription());
        todo.setStatus(todos.getStatus());
        return todolistRepo.save(todo);
    }

    public void deleteTodo(int id) {
        TodoList todo = todolistRepo.findById(id).orElseThrow();
        todolistRepo.delete(todo);
    }

    public List<TodoList> sorting(String sortBy) {
        return todolistRepo.findAll(Sort.by(sortBy));

    }
}
