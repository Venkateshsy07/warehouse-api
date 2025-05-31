package com.example.warehouse.dto.response;

public record WareHouseResponse(
        String wareHouseId,
        String wareHouseName,
        String location,
        String admins,
        String landmark) {
}
