package com.example.warehouse.dto.response;

public record RackResponse(
        String rackId,
        double height,
        double length,
        double breadth
) {
}