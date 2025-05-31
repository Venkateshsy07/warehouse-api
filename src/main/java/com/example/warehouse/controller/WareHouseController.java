package com.example.warehouse.controller;

import com.example.warehouse.dto.request.WareHouseRequest;
import com.example.warehouse.dto.response.WareHouseResponse;
import com.example.warehouse.service.WareHouseService;
import com.example.warehouse.utility.ResponseStructure;
import com.example.warehouse.utility.RestResponceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouses")
public class WareHouseController {
    @Autowired
    private WareHouseService wareHouseService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<ResponseStructure<WareHouseResponse>> addWareHouse(@RequestBody WareHouseRequest request, @PathVariable String userId) {
        
        WareHouseResponse wareHouseResponse = wareHouseService.addWareHouse(request,userId);
        return RestResponceBuilder.ok("Warehouse Added", wareHouseResponse, HttpStatus.CREATED);
    }

}
