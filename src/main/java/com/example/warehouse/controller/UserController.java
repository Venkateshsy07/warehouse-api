package com.example.warehouse.controller;

import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.service.UserService;
import com.example.warehouse.utility.ResponseStructure;
import com.example.warehouse.utility.RestResponceBuilder;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRequest urr) {
        UserResponse userResponse = userService.addUser(urr);
        return RestResponceBuilder.ok("User Added", userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<ResponseStructure<UserResponse>> findById(@RequestParam String id) {
        UserResponse userResponse = userService.findById(id);
        return RestResponceBuilder.ok("Found User", userResponse, HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN'))")
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<UserResponse>> updateById(
            @RequestParam String id,
            @RequestBody UserRequest request) {
        UserResponse userResponse = userService.updateUser(request);
        return RestResponceBuilder.ok("User Updated ", userResponse, HttpStatus.CREATED);
    }


}
