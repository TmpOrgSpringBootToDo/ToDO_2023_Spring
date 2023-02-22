package com.thanu.work.todo2023.api;

import com.thanu.work.todo2023.dto.ToDoDTO;
import com.thanu.work.todo2023.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/todotask/{userId:[A-Fa-f0-9\\-]{36}}")
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
    @DeleteMapping(path = "/{toDoId:\\d+}")
    public void deleteToDo (@PathVariable String userId, @PathVariable int toDoId){
        toDoService.deleteToDo(userId, toDoId);
    }
    @GetMapping(produces = "application/json")
    public List<ToDoDTO>getAllToDos(@PathVariable String userId){
        return toDoService.getAllToDos(userId);
    }

}
