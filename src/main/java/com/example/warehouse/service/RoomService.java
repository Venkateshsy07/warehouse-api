package com.example.warehouse.service;

import com.example.warehouse.dto.request.RoomRequest;
import com.example.warehouse.dto.response.RoomResponse;

public interface RoomService {
    RoomResponse createRoom(RoomRequest request, String warehouseId);
}
