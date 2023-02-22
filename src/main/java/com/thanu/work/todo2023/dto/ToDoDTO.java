package com.thanu.work.todo2023.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongodb.internal.connection.Time;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoDTO implements Serializable {
    private Integer toDoId;
    @Pattern(regexp = "[A-Fa-f0-9\\-]{36}",message = "Invalid user ID")
    private String userIdTodo;
    @NotBlank(message = "To do can not be an empty value")
    private String toDo;
    private String email;



}
