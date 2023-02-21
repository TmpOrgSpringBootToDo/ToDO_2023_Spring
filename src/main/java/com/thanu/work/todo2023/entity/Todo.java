package com.thanu.work.todo2023.entity;

import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo implements SuperEntity{
    @Id
    private Long id;
    private String toDo;
    private Date date;
    private Time time;
    private Boolean isCompleted = Boolean.FALSE;

    private User user;

    public Todo(String todo, User user) {
        this.toDo = todo;
        this.user = user;
    }

    public Todo(String todo, Date date, Time time, User user) {
        this.toDo = todo;
        this.date = date;
        this.time = time;
        this.user = user;
    }

}
