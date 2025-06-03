package com.example.warehouse.serviceimpl;

import com.example.warehouse.exception.InvalidUserRole;
import com.example.warehouse.exception.UserNotFoundWithid;
import com.example.warehouse.exception.UsernotLogedIn;
import com.example.warehouse.mapper.UserMapper;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.entity.Admin;
import com.example.warehouse.entity.Staff;
import com.example.warehouse.entity.User;
import com.example.warehouse.enums.UserRole;
import com.example.warehouse.repository.UserRepository;
import com.example.warehouse.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.example.warehouse.Security.AuthUtils.*;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper=new UserMapper();
    private final PasswordEncoder passwordEncoder;

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
        String encodedPassword=passwordEncoder.encode(urr.password());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return userMapper.userToResponse(user);
    }

    @Override
    public UserResponse findById(String userId) {
        User user =getCurrentUserName().map(
                userName -> userRepository.findById(userName)
                        .orElseThrow(() -> new UsernotLogedIn("User with ID " + userName + " not found"))
        ).orElseThrow(
                () -> new UsernotLogedIn("User with ID  not found"));
        return userMapper.userToResponse(user);
    }

    @Override
    public UserResponse updateUser(UserRequest request) {

        User existingUser =getCurrentUserName().map(
                username -> userRepository.findByEmail(username)
                        .orElseThrow(() -> new UserNotFoundWithid("User  not found by this id"))
        ).orElseThrow(
                () -> new UsernotLogedIn("User with ID not found"));


        User user = userMapper.userToEntity(request,existingUser);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return userMapper.userToResponse(user);
    }

    public UserResponse findUserByid(){
        User user=getCurrentUserName().map(
                username->userRepository.findByEmail(username).orElseThrow(()->new UserNotFoundWithid("User with ID not found"))).orElseThrow(
                ()->new UsernotLogedIn("User  not LogedIN"));
        return userMapper.userToResponse(user);
    }
    @Override
    public UserResponse deleteUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundWithid("UserId Not Found!!"));
        userRepository.delete(user);
        return userMapper.userToResponse(user);
    }

}

