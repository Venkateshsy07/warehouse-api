package com.example.warehouse.dto.request;

public record WareHouseRequest(
        String userId,
        String warehouseName,
        String city,
        String landmark,
        String address
) {
}
