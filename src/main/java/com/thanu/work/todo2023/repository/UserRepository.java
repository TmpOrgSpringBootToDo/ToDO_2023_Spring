package com.thanu.work.todo2023.repository;

import com.thanu.work.todo2023.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

}
