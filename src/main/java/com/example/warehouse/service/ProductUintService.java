package com.example.warehouse.service;

import com.example.warehouse.dto.request.InventoryLocationUpdateRequest;
import com.example.warehouse.dto.response.ProductUnitResponse;

public interface ProductUintService {
    ProductUnitResponse updateLocation(InventoryLocationUpdateRequest updateRequest);
}