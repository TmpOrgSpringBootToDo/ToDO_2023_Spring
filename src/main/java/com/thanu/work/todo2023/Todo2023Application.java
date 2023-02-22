package com.thanu.work.todo2023;

import com.thanu.work.todo2023.repository.ToDoRepository;
import com.thanu.work.todo2023.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Todo2023Application {
@Bean
    public ModelMapper modelMapper(){
	return new ModelMapper();

}


	public static void main(String[] args) {
		SpringApplication.run(Todo2023Application.class, args);
	}

}
