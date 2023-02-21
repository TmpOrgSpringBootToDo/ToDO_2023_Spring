package com.thanu.work.todo2023;

import com.thanu.work.todo2023.repository.ToDoRepository;
import com.thanu.work.todo2023.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Todo2023Application {



	public static void main(String[] args) {
		SpringApplication.run(Todo2023Application.class, args);
	}

}
