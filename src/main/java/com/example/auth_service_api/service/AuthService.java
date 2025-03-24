package com.example.auth_service_api.service;

import com.example.auth_service_api.commons.dtos.TokenResponse;
import com.example.auth_service_api.commons.dtos.UserRequest;

public interface AuthService {
    TokenResponse createUser(UserRequest userRequest);

    TokenResponse loginUser(String userEmail, String userPassword);
}
