package com.example.warehouse.dto.response;

public record ClientResponse(
        String clientId,
        String OrganizationName,
        String OrganizationEmail,
        String ApiKey,
        String secretKey,
        long RegestriedAt
) {
}
