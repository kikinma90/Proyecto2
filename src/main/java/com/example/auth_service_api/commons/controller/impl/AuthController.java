package com.example.auth_service_api.commons.controller.impl;

import com.example.auth_service_api.commons.controller.AuthApi;
import com.example.auth_service_api.commons.dtos.TokenResponse;
import com.example.auth_service_api.commons.dtos.UserRequest;
import com.example.auth_service_api.commons.service.AuthService;
import com.example.auth_service_api.commons.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

    private final AuthService authService;

    public AuthController(JwtService jwtService, AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }

    @Override
    public ResponseEntity<TokenResponse> loginUser(String userEmail, String userPassword) {
        return ResponseEntity.ok(authService.loginUser(userEmail, userPassword));
    }
}
