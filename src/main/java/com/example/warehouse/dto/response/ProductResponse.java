package com.example.warehouse.dto.response;

public record ProductResponse(  String productId,
                                String title,
                                double weight,
                                double length,
                                double height,
                                double width,
                                String materialType,
                                String careInstruction,
                                double price) {
}
