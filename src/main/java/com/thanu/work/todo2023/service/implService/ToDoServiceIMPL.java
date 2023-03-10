package com.thanu.work.todo2023.service.implService;

import com.thanu.work.todo2023.dto.ToDoDTO;
import com.thanu.work.todo2023.entity.Todo;
import com.thanu.work.todo2023.entity.User;
import com.thanu.work.todo2023.excptions.NotFoundException;
import com.thanu.work.todo2023.excptions.UnauthorizedAccessException;
import com.thanu.work.todo2023.repository.ToDoRepository;
import com.thanu.work.todo2023.repository.UserRepository;
import com.thanu.work.todo2023.service.ToDoService;
import com.thanu.work.todo2023.service.utilize.EntityToDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ToDoServiceIMPL implements ToDoService {

    public final UserRepository userRepository;
    public final ToDoRepository toDoRepository;
    public final EntityToDTO entityToDTO;

    public ToDoServiceIMPL(UserRepository userRepository, EntityToDTO entityToDTO, ToDoRepository toDoRepository) {
        this.userRepository = userRepository;
        this.entityToDTO = entityToDTO;
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDoDTO saveToDoDetails(ToDoDTO toDoDTO) throws NotFoundException {
        Todo toDoEntity = entityToDTO.getToDoEntity(toDoDTO);
        toDoEntity.setUser(getUser(toDoDTO.getUserIdTodo()));
        return entityToDTO.getToDoDTO(toDoRepository.save(entityToDTO.getToDoEntity(toDoDTO)));
    }

    //update tododata
    public void updateToDO(ToDoDTO todoDTO) throws NotFoundException {
        Optional<Todo> tmpTodo = toDoRepository.findById(todoDTO.getToDoId());
        if (!tmpTodo.isPresent()) throw new NotFoundException("To Do not found");
        tmpTodo.get().setToDo(todoDTO.getToDo());
        tmpTodo.get().setDateTime(todoDTO.getDateTime());
        tmpTodo.get().setIsComplete(todoDTO.getIsComplete());
    }

    @Override
    public List<ToDoDTO> getAllToDos(String userId) {
        return toDoRepository.findAllToDosByUser(getUser(userId))
                .stream().map(entityToDTO::getToDoDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteToDo(String userId, int toDoId) throws NotFoundException {
        Todo todo = toDoRepository
                .findById(toDoId)
                .orElseThrow(() -> new NotFoundException("Invalid ToDo")
                );
        if (getUser(userId) == todo.getUser()) {
            toDoRepository.deleteById(toDoId);
        }else{
            throw new UnauthorizedAccessException("Not allow to delete");
        }
    }

    private User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
    }
}
