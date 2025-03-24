package com.example.auth_service_api.commons.controller;

import com.example.auth_service_api.commons.constants.ApiPathConstants;
import com.example.auth_service_api.commons.entities.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface UserApi {

    @GetMapping(value = "/{userId}")
    ResponseEntity<UserModel> getUser(
            @PathVariable Long userId
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
