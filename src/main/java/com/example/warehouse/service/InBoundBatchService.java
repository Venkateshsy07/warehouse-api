package com.example.warehouse.service;

import com.example.warehouse.dto.request.InBoundBatchRequest;
import com.example.warehouse.dto.request.InventoryLocationUpdateRequest;
import com.example.warehouse.dto.response.InBoundBatchResponse;
import com.example.warehouse.dto.response.ProductUnitResponse;

import java.util.List;

public interface InBoundBatchService {
    InBoundBatchResponse receiveProductUnit(InBoundBatchRequest request, String shipmentId);

    List<ProductUnitResponse> updateInventoryLocation(InventoryLocationUpdateRequest request);

    byte[] generateQRCodeImage(String rackId);
}
