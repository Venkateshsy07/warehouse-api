package com.example.warehouse.service;


import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;

public interface RackService {

    RackResponse createRoom(RackRequest rackRequest,String userId);

    byte[] generateRackBarCode(String rackId);
}