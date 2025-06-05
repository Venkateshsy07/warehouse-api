package com.example.warehouse.dto.request;

public record InBoundBatchRequest(
        int countOfRejectedUnit,
        int countOfAcceptedUnit
) {
}