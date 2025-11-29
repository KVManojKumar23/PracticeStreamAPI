package com.Streams.PracticeStreamAPI.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Streams.PracticeStreamAPI.DTO.RegisterResponseDTO;
import com.Streams.PracticeStreamAPI.DTO.UserDTO;
import com.Streams.PracticeStreamAPI.Services.Interfaces.IUser;
import com.Streams.PracticeStreamAPI.domain.User;
import com.Streams.PracticeStreamAPI.domain.enums.Status;
import com.Streams.PracticeStreamAPI.exception.DuplicateUserException;
import com.Streams.PracticeStreamAPI.exception.UserNotFoundException;
import com.Streams.PracticeStreamAPI.repository.UserRepo;

@Service
public class UserIMPL implements IUser {

    private final PasswordEncoder passwordEncoder;

    private final UserRepo userRepo;

    public UserIMPL(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    private UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .userName(user.getUserName())
                .role(user.getRole())
                .status(user.getStatus())
                .gender(user.getGender())
                .build();
    }

    private User toEntity(UserDTO userDTO) {
        if (userDTO == null)
            return null;

        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .userName(userDTO.getUserName())
                .role(userDTO.getRole())
                .status(userDTO.getStatus())
                .gender(userDTO.getGender())
                .build();
    }

    private RegisterResponseDTO toResponseDTO(User user) {
        if (user == null)
            return null;

        return new RegisterResponseDTO().builder()
                .name(user.getName())
                .userName(user.getUserName())
                .role(user.getRole())
                .gender(user.getGender())
                .status(user.getStatus())
                .build();

    }

    @Override
    public RegisterResponseDTO register(UserDTO user) {
        // check for duplicate username instead of ID
        if (userRepo.findByUserName(user.getUserName()).isPresent()) {
            throw new DuplicateUserException("User already exists: " + user.getUserName());
        }

        User registerUser = toEntity(user);

        // encode password
        registerUser.setPassword(passwordEncoder.encode(user.getPassword()));

        // default status if not provided
        if (user.getStatus() == null) {
            registerUser.setStatus(Status.ACTIVE);
        }

        // save user to DB
        registerUser = userRepo.save(registerUser);

        return toResponseDTO(registerUser);
    }

    @Override
    @Transactional()
    public UserDTO updateUser(UserDTO user) {
        User updateUser = userRepo.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("User Not Found :: " + user.getUserName()));

        updateUser = toEntity(user);

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        updateUser = userRepo.save(updateUser);

        return toDTO(updateUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserById(Integer id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found :: " + id));

        return toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found :: " + id));
        userRepo.delete(user);
    }

}
