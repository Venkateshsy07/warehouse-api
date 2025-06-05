package com.example.warehouse.controller;


import com.example.warehouse.dto.request.RoomRequest;
import com.example.warehouse.dto.response.RoomResponse;

import com.example.warehouse.entity.Room;
import com.example.warehouse.service.RoomService;

import com.example.warehouse.utility.ResponseStructure;
import com.example.warehouse.utility.RestResponceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/rooms/{warehouseId}")
    public ResponseEntity<ResponseStructure<RoomResponse>> createRoom(@RequestBody RoomRequest request, @PathVariable String warehouseId) {
        RoomResponse roomResponse = roomService.createRoom(request, warehouseId);
        return RestResponceBuilder.created("Room Created Successfully", roomResponse, HttpStatus.CREATED);
    }
}

