
package com.example.warehouse.controller;

import com.example.warehouse.dto.request.InBoundBatchRequest;
import com.example.warehouse.dto.response.InBoundBatchResponse;
import com.example.warehouse.service.InBoundBatchService;
import com.example.warehouse.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InBoundBatchController {

    @Autowired
    private InBoundBatchService inBoundBatchService;

    @PostMapping("/batch/{shipmentId}")
    public ResponseEntity<ResponseStructure<InBoundBatchResponse>> createInboundBatch(@RequestBody InBoundBatchRequest request, @PathVariable String shipmentId){
        InBoundBatchResponse inBoundBatchResponse =  inBoundBatchService.receiveProductUnit(request,shipmentId);
        ResponseStructure<InBoundBatchResponse> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "Units Are Added !!",inBoundBatchResponse);
        return new ResponseEntity<ResponseStructure<InBoundBatchResponse>>(responseStructure,HttpStatus.CREATED);
    }

    @GetMapping("/product/qrcode/{unit}")
    public ResponseEntity<byte[]> generateProductQrCode(@PathVariable String unitId) {
        byte[] barCode = inBoundBatchService.generateQRCodeImage(unitId);
        return ResponseEntity.ok()
                .header("Content-Type", "image/png")
                .body(barCode);
    }
}
