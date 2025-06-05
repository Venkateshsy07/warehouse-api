package com.example.warehouse.dto.request;

public record ProductRequest(
        String productId,
        String productTitle,
        double productWeight,
        double productLength,
        double productHeight,
        double productWidth,
        String materialType,
        String careInstruction,
        double productPrice
) {
}
