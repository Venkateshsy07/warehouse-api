package com.example.warehouse.controller;

import com.example.warehouse.dto.request.BlockRequest;
import com.example.warehouse.dto.response.BlockResponse;
import com.example.warehouse.service.BlockService;
import com.example.warehouse.utility.ResponseStructure;
import com.example.warehouse.utility.RestResponceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockController {

    @Autowired
    private BlockService blockService;

    @PostMapping("/blocks/{RoomId}")
    public ResponseEntity<ResponseStructure<BlockResponse>> createBlock(@RequestBody BlockRequest request, @PathVariable String RoomId) {
        BlockResponse blockResponse = blockService.createBlock(request, RoomId);
        return RestResponceBuilder.created("Block Created Successfully", blockResponse, HttpStatus.CREATED);
    }


}
