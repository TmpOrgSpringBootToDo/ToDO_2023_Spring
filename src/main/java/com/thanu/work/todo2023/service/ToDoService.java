package com.thanu.work.todo2023.service;

import com.thanu.work.todo2023.dto.ToDoDTO;
import com.thanu.work.todo2023.dto.UserDTO;
import com.thanu.work.todo2023.excptions.DuplicateUserIdException;
import com.thanu.work.todo2023.excptions.NotFoundException;

import java.util.List;

public interface ToDoService {
    ToDoDTO saveToDoDetails(ToDoDTO toDoDTO) throws NotFoundException;
    List<ToDoDTO> getAllToDos(String userId);

    void updateToDO(ToDoDTO todoDTO) throws NotFoundException;
    void deleteToDo(String userId,int toDoId) throws NotFoundException;
}
