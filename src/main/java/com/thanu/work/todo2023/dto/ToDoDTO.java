package com.thanu.work.todo2023.dto;

import com.mongodb.internal.connection.Time;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

public class ToDoDTO implements Serializable {
    private Long id;
    @NotBlank(message = "To do can not be an empty value")
    private String toDo;
    private Date date;
    private Time time;
    private Boolean isCompleted = Boolean.FALSE;
}
