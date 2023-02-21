package com.thanu.work.todo2023.service;

import com.thanu.work.todo2023.dto.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    UserDTO getUserInfo(String userId);
    void deleteUser(String userId);
}
