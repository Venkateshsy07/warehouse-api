package com.example.warehouse.service;

import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;

public interface UserService {
    UserResponse addUser(UserRequest user);
    UserResponse findById(String userId);

    UserResponse updateById(String id, UserRequest updatedUser);
}
