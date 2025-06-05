package com.example.warehouse.dto.request;

import com.example.warehouse.enums.InBoundStatus;

import java.util.List;

public record InBoundShipmentRequest(
        String sellerId,
        ProductRequest productDetails,
        InBoundStatus status,
        int quantity
) {
}