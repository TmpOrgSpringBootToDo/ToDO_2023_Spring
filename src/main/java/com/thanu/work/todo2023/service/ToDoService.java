package com.thanu.work.todo2023.service;

import com.thanu.work.todo2023.dto.ToDoDTO;

import java.util.List;

public interface ToDoService {
    ToDoDTO saveToDoDetails(ToDoDTO toDoDTO);
    List<ToDoDTO> getAllToDos(String userId);
    void deleteToDo(String userId,int toDoId);
}
