package com.example.warehouse.dto.request;

import com.example.warehouse.entity.ProductUnit;

import java.util.Set;


public record InventoryLocationUpdateRequest(
        String blockId,
        String rackId,
        int shelfNo,
        Set<String> unitId
) {
}