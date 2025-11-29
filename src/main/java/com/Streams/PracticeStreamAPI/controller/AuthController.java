package com.Streams.PracticeStreamAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Streams.PracticeStreamAPI.DTO.LoginRequestDTO;
import com.Streams.PracticeStreamAPI.DTO.LoginResponseDTO;
import com.Streams.PracticeStreamAPI.DTO.RegisterResponseDTO;
import com.Streams.PracticeStreamAPI.DTO.UserDTO;
import com.Streams.PracticeStreamAPI.Services.Interfaces.IUser;
import com.Streams.PracticeStreamAPI.domain.User;
import com.Streams.PracticeStreamAPI.exception.UserNotFoundException;
import com.Streams.PracticeStreamAPI.repository.UserRepo;
import com.Streams.PracticeStreamAPI.utills.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepo userRepo;
    private final IUser userService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserRepo userRepo,
            IUser userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        if (userRepo.existsByUserName(userDTO.getUserName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Username already exists");
        }
        RegisterResponseDTO registerResponseDTO = userService.register(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDto,
            HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUserName(),
                        loginRequestDto.getPassword()));

        User user = userRepo.findByUserName(loginRequestDto.getUserName())
                .orElseThrow(() -> new UserNotFoundException("User Not Found :: " +
                        loginRequestDto.getUserName()));

        String jwt = jwtUtils.generateToken((UserDetails) authentication.getPrincipal());
        LoginResponseDTO loginResponseDto = new LoginResponseDTO();
        loginResponseDto.setToken(jwt);
        loginResponseDto.setRole(user.getRole());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginResponseDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String token = jwtUtils.extractTokenFromRequest(request);
        jwtUtils.invalidateToken(token); // add to blacklist
        return ResponseEntity.ok("User logged out successfully");
    }

}
