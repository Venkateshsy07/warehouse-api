package com.example.warehouse.controller;

import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.service.UserService;
import com.example.warehouse.utility.ResponseStructure;
import com.example.warehouse.utility.RestResponceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRequest urr) {
        UserResponse userResponse = userService.addUser(urr);
        return RestResponceBuilder.ok("User Added", userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<ResponseStructure<UserResponse>> findById(@RequestParam String id) {
        UserResponse userResponse = userService.findById(id);
        return RestResponceBuilder.ok("Found User", userResponse, HttpStatus.OK);
    }

    // update logic
}
