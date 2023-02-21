package com.thanu.work.todo2023.dto;

import com.mongodb.internal.connection.Time;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoDTO implements Serializable {
    private Long id;
    @Pattern(regexp = "[A-Fa-f0-9\\-]{36}",message = "Invalid user ID")
    private String userId;
    @NotBlank(message = "To do can not be an empty value")
    private String toDo;
    private Date date;
    private Time time;
    private Boolean isCompleted = Boolean.FALSE;
}
