package com.thanu.work.todo2023.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo implements SuperEntity{
    @Id
    private Integer toDoId;
    private String userIdTodo;
    private String toDo;
    private String email;
    private User user;

    public Todo(String todo, User user) {
        this.toDo = todo;
        this.user = user;
    }


}
