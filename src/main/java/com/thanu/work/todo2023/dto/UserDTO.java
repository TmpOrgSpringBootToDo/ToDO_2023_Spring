package com.thanu.work.todo2023.dto;

import com.thanu.work.todo2023.entity.Todo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    @Null(message = "Id is automatically generated")
    private String id;

    @NotNull(message = "User name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+")
    private String userName;

    @NotBlank(message = "Password cannot be an empty value")
    @Length(min = 5)
    private String password;

    private List<Todo> todoList;
}
