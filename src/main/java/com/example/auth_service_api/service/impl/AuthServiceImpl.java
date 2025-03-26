package com.example.auth_service_api.service.impl;

import com.example.auth_service_api.commons.dtos.TokenResponse;
import com.example.auth_service_api.commons.dtos.UserLogin;
import com.example.auth_service_api.commons.dtos.UserRequest;
import com.example.auth_service_api.commons.entities.UserModel;
import com.example.auth_service_api.service.AuthService;
import com.example.auth_service_api.service.JwtService;
import com.example.auth_service_api.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getUserId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    @Override
    public TokenResponse loginUser(UserLogin userLogin) {
        return userRepository.findByEmail(userLogin.getEmail())
                .filter(user -> passwordEncoder.matches(userLogin.getPassword(), user.getPassword()))
                .map(user -> jwtService.generateToken(user.getUserId()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    private UserModel mapToEntity(UserRequest userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .name(userRequest.getName())
                .role("USER")
                .build();
    }
}
