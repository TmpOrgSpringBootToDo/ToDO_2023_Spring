package com.thanu.work.todo2023.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements SuperEntity {
    @Id
    private String id;
    private String userName;
    private String email;
    private String password;
//    private List<Todo> todoList = new ArrayList<>();
}
