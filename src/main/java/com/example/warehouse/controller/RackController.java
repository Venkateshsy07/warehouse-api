package com.example.warehouse.controller;


import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;
import com.example.warehouse.service.RackService;
import com.example.warehouse.utility.ResponseStructure;
import com.example.warehouse.utility.RestResponceBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class RackController {


    private final RackService rackService;


    @PostMapping("/rack/{blockId}")
    public ResponseEntity<ResponseStructure<RackResponse>> addRoom(@RequestBody RackRequest rackRequest,@PathVariable String blockId){
        RackResponse rackResponse=rackService.createRoom(rackRequest, blockId);
        return RestResponceBuilder.created("Rack Created Successfully",rackResponse, HttpStatus.CREATED);
    }


    @GetMapping("/rack/barcode/{rackId}")
    public ResponseEntity<byte[]> generateRackBarCode(@PathVariable String rackId) {
        byte[] barCode = rackService.generateRackBarCode(rackId);
        return ResponseEntity.ok()
                .header("Content-Type", "image/png")
                .body(barCode);
    }
}