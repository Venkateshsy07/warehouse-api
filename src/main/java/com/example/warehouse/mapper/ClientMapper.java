package com.example.warehouse.mapper;

import com.example.warehouse.dto.request.ClientRequest;
import com.example.warehouse.dto.response.ClientResponse;
import com.example.warehouse.entity.Client;

public class ClientMapper{
        public static ClientResponse toResponse(Client client, String rawSecretKey) {
        return new ClientResponse(
            client.getClientId(),
            client.getOrganizationName(),
            client.getOrganizationEmail(),
            client.getApiKey(),
            rawSecretKey,
            client.getRegestriedAt().toEpochMilli()
        );
    }

    public static Client toClientEntity(ClientRequest source, String apiKey, String secretKey, Client target) {
        target.setOrganizationName(source.OrganizationName());
        target.setOrganizationEmail(source.OrganizationEmail());
        target.setApiKey(apiKey);
        target.setSecretKey(secretKey);

        return  target;
    }
}
