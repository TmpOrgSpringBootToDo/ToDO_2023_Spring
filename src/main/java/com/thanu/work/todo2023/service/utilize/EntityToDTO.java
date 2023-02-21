package com.thanu.work.todo2023.service.utilize;

import com.thanu.work.todo2023.dto.ToDoDTO;
import com.thanu.work.todo2023.dto.UserDTO;
import com.thanu.work.todo2023.entity.Todo;
import com.thanu.work.todo2023.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityToDTO {
    private ModelMapper modelMapper;

    public EntityToDTO(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    public User getUserEntity (UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
    public UserDTO getUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }
    public Todo getToDoEntity(ToDoDTO toDoDTO){
        return modelMapper.map(toDoDTO, Todo.class);
    }
    public ToDoDTO getToDoDTO(Todo todoEntity){
        return modelMapper.typeMap(Todo.class, ToDoDTO.class)
                .addMapping(todo -> todo.getUser().getId(),ToDoDTO::setUserId)
                .map(todoEntity);
    }



}
