package com.example.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String taskName;
    private String taskDescription;
    private String status;
}
