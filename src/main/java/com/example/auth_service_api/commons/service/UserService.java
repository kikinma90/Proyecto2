package com.example.auth_service_api.commons.service;

import com.example.auth_service_api.commons.entities.UserModel;

public interface UserService {

    UserModel getUser(Long userId);

    void updateUser(Long userId, UserModel gameRequest);

    void deleteUser(Long userId);
}
