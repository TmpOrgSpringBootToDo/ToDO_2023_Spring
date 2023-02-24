package com.thanu.work.todo2023.api;

import com.thanu.work.todo2023.dto.ToDoDTO;
import com.thanu.work.todo2023.dto.UserDTO;
import com.thanu.work.todo2023.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/users/{userId:[A-Fa-f0-9\\-]{36}}/todo")
public class ToDoController {
    private final ToDoService toDoService;
    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    public ToDoDTO addToDo(@PathVariable String userId, @RequestBody @Valid ToDoDTO toDoDTO, Errors errors){
        if(errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.getFieldErrors()
                    .get(0).getDefaultMessage());
        }
       if(!userId.equals(toDoDTO.getUserIdTodo()))
           throw new ResponseStatusException(HttpStatus.CONFLICT,"User id is mismatch");
           return toDoService.saveToDoDetails(toDoDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{toDoId}",consumes = "application/json")
    public void updateToDo(@PathVariable int toDoId, @RequestBody ToDoDTO toDoDTO, Errors errors){
        if(errors.hasFieldErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getFieldErrors()
                    .get(0).getDefaultMessage());
        }
        toDoDTO.setToDoId(toDoId);
        toDoService.updateToDO(toDoDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{toDoId:\\d+}")
    public void deleteToDo (@PathVariable String userId, @PathVariable int toDoId){
        toDoService.deleteToDo(userId, toDoId);
    }
    @GetMapping(produces = "application/json")
    public List<ToDoDTO>getAllToDos(@PathVariable String userId){
        return toDoService.getAllToDos(userId);
    }

}
