package com.example.warehouse.controller;


import com.example.warehouse.dto.request.InBoundShipmentRequest;
import com.example.warehouse.dto.response.InBoundShipmentResponse;

import com.example.warehouse.service.InBoundShipmentService;

import com.example.warehouse.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InBoundShipmentController {

    @Autowired
    private InBoundShipmentService inBoundShipmentService;
    @PreAuthorize("hasAuthority('CLIENT')")
    @PostMapping("/receive/shipment/{wareHouseId}")
    public ResponseEntity<ResponseStructure<InBoundShipmentResponse>> receiveProductInWareHouse(@RequestBody InBoundShipmentRequest request, @PathVariable String wareHouseId){
        System.out.println(request);
        InBoundShipmentResponse inBoundShipmentResponse = inBoundShipmentService.receiveProductInWareHouse(request,wareHouseId);
        ResponseStructure<InBoundShipmentResponse> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "Product Added In The WareHouse",inBoundShipmentResponse);
        return new ResponseEntity<ResponseStructure<InBoundShipmentResponse>>(responseStructure,HttpStatus.CREATED);
    }
}