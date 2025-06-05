package com.example.warehouse.controller;

import com.example.warehouse.dto.request.InventoryLocationUpdateRequest;
import com.example.warehouse.dto.response.ProductUnitResponse;
import com.example.warehouse.service.InBoundBatchService;
import com.example.warehouse.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    public class InventoryLocationUpdateController {

        @Autowired
        private InBoundBatchService inBoundBatchService;

        @PutMapping("/update-location")
        public ResponseEntity<com.example.warehouse.utility.ResponseStructure<List<ProductUnitResponse>>> updateLocation(@RequestBody InventoryLocationUpdateRequest request){
            List<ProductUnitResponse> productUnitResponse = inBoundBatchService.updateInventoryLocation(request);
            ResponseStructure<List<ProductUnitResponse>> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "Location Updated Successfully!!",productUnitResponse);
            return new ResponseEntity<>(responseStructure,HttpStatus.CREATED);
        }
    }

