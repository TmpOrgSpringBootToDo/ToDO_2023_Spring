package com.thanu.work.todo2023.repository;

import com.thanu.work.todo2023.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<Todo,Long> {

}
