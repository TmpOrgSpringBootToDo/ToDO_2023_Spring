package com.thanu.work.todo2023.repository;

import com.thanu.work.todo2023.entity.Todo;
import com.thanu.work.todo2023.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<Todo,Integer> {
    List<Todo> findAllToDosByUser(User user);

    long countToDosByUser(User user);
}
