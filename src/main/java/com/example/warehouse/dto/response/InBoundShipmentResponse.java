package com.example.warehouse.dto.response;

import com.example.warehouse.enums.InBoundStatus;

public record InBoundShipmentResponse(String shipmentId,
                                      String sellerId,
                                      InBoundStatus status,
                                      int quantity,
                                      long createdAt,
                                      ProductResponse productResponse) {
}
