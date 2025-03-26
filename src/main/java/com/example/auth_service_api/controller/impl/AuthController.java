package com.example.auth_service_api.controller.impl;

import com.example.auth_service_api.commons.dtos.UserLogin;
import com.example.auth_service_api.controller.AuthApi;
import com.example.auth_service_api.commons.dtos.TokenResponse;
import com.example.auth_service_api.commons.dtos.UserRequest;
import com.example.auth_service_api.service.AuthService;
import com.example.auth_service_api.service.JwtService;
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
    public ResponseEntity<TokenResponse> loginUser(UserLogin userLogin) {
        return ResponseEntity.ok(authService.loginUser(userLogin));
    }
}
