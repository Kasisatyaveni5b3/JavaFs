package com.example.springapp.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Task name cannot be empty")
    private String taskName;
    @NotBlank(message = "Task description cannot be empty")
    private String taskDescription;
    @NotBlank(message = "Task status cannot be empty")
    private String status;

    @CreationTimestamp
    @JsonFormat(
        pattern = "yyyy-MM-dd'T'HH:mm:ss"
    )
    private OffsetDateTime createdAt;
    
    @UpdateTimestamp
    @JsonFormat(
        pattern = "yyyy-MM-dd'T'HH:mm:ss"
    )
    private OffsetDateTime updatedAt;
}
