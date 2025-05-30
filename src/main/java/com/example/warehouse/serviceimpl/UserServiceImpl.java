package com.example.warehouse.serviceimpl;

import com.example.warehouse.exception.InvalidUserRole;
import com.example.warehouse.exception.UserNotFoundWithid;
import com.example.warehouse.mapper.UserMapper;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.entity.Admin;
import com.example.warehouse.entity.Staff;
import com.example.warehouse.entity.User;
import com.example.warehouse.enums.UserRole;
import com.example.warehouse.repository.UserRepository;
import com.example.warehouse.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse addUser(UserRequest urr) {
        User user;
        if (urr.userRole().equals(UserRole.STAFF)) {
            user = userMapper.userToEntity(urr, new Staff());
        } else if (urr.userRole().equals(UserRole.ADMIN)) {
            user = userMapper.userToEntity(urr, new Admin());
        } else {
            throw new InvalidUserRole("Invalid user role");
        }
        userRepository.save(user);
        return userMapper.userToResponse(user);
    }

    @Override
    public UserResponse findById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundWithid("User with ID " + userId + " not found"));
        return userMapper.userToResponse(user);
    }
}