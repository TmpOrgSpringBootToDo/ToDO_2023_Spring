package com.thanu.work.todo2023.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer toDoId;

    @Column(nullable = false)
    private String toDo;
    @Column(name = "dateand_Time")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",nullable = false)
    private User user;

    public Todo(String todo, User user) {
        this.toDo = todo;
        this.user = user;
    }


}
