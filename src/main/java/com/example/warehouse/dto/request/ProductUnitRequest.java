package com.example.warehouse.dto.request;

public record ProductUnitRequest(
        String location,
        InBoundBatchRequest inBoundBatchRequest
) {
}