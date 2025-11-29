package com.Streams.PracticeStreamAPI.Services.Interfaces;

import java.util.List;

import com.Streams.PracticeStreamAPI.DTO.RegisterResponseDTO;
import com.Streams.PracticeStreamAPI.DTO.UserDTO;

public interface IUser {

    RegisterResponseDTO register(UserDTO user);

    UserDTO updateUser(UserDTO user);

    UserDTO getUserById(Integer id);

    List<UserDTO> getAllUsers();

    void deleteUser(Integer id);

}
