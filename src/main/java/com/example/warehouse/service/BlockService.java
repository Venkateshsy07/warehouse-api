package com.example.warehouse.service;

import com.example.warehouse.dto.request.BlockRequest;
import com.example.warehouse.dto.response.BlockResponse;

public interface BlockService {
    BlockResponse createBlock(BlockRequest request, String roomId);
}
