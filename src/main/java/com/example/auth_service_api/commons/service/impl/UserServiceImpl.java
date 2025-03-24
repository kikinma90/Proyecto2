package com.example.auth_service_api.commons.service.impl;

import com.example.auth_service_api.commons.entities.UserModel;
import com.example.auth_service_api.commons.service.UserService;
import com.example.auth_service_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel getUser(Long userId) {
        return Optional.of(userId)
                .flatMap(userRepository::findById)
                .orElseThrow(() -> new RuntimeException("Error couldn't find user by id"));
    }

    @Override
    public void updateUser(Long userId, UserModel userRequest) {
        userRepository.findById(userId)
                        .map(existingUser -> {
                           existingUser.setEmail(userRequest.getEmail());
                            existingUser.setName(userRequest.getName());
                            existingUser.setRole(userRequest.getRole());
                            return userRepository.save(existingUser);
                        })
                        .orElseThrow(() -> new RuntimeException("Error couldn't update user by id"));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                        .ifPresent(userRepository::delete);
    }

}
