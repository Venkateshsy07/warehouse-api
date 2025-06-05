package com.example.warehouse.dto.response;

public record InBoundBatchResponse(
        String batchId,
        int countOfRejectedUnit,
        int countOfAcceptedUnit
) {
}