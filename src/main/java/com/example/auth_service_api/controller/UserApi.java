package com.example.auth_service_api.controller;

import com.example.auth_service_api.commons.constants.ApiPathConstants;
import com.example.auth_service_api.commons.entities.UserModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
public interface UserApi {

    @GetMapping()
    ResponseEntity<UserModel> getUser(
            @RequestAttribute("X-User-Id") Long userId
    );

    @PutMapping(value = "/{userId}")
    ResponseEntity<Void> updateUser(
            @PathVariable Long userId,
            @RequestBody UserModel gameRequest
    );

    @DeleteMapping(value = "/{userId}")
    ResponseEntity<Void> deleteUser(
            @PathVariable Long userId
    );
}
