package com.example.warehouse.dto.request;

import com.example.warehouse.enums.UserRole;

public record UserRequest(
        String username,
        String email,
        String password,
        UserRole userRole
) {
}
