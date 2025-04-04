package com.example.auth_service_api.controller;

import com.example.auth_service_api.commons.constants.ApiPathConstants;
import com.example.auth_service_api.commons.entities.UserModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.USER_ROUTE)
@SecurityRequirement(name = "Bearer Authorization")
public interface UserApi {

    @GetMapping()
    ResponseEntity<UserModel> getUser(
            @RequestAttribute("X-User-Id") Long userId
    );

    @PutMapping()
    ResponseEntity<Void> updateUser(
            @RequestAttribute("X-User-Id") Long userId,
            @RequestBody UserModel gameRequest
    );

    @DeleteMapping()
    ResponseEntity<Void> deleteUser(
            @RequestAttribute("X-User-Id") Long userId
    );
}
