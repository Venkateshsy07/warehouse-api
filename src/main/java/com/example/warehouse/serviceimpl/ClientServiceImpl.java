package com.example.warehouse.serviceimpl;

import com.example.warehouse.dto.request.ClientRequest;
import com.example.warehouse.dto.response.ClientResponse;
import com.example.warehouse.entity.Client;
import com.example.warehouse.mapper.ClientMapper;
import com.example.warehouse.repository.ClientRepository;
import com.example.warehouse.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository; // Assuming you have a ClientRepository to handle database operations

    public ClientResponse registerClient(@RequestBody ClientRequest clientRequest) {
        String apiKey = UUID.randomUUID().toString();
        String secretKey = Base64.getEncoder().encodeToString(new SecureRandom().generateSeed(32));

        String encodedSecretKey = passwordEncoder.encode(secretKey);

        Client client = ClientMapper.toClientEntity(clientRequest, apiKey, encodedSecretKey, new Client());

        clientRepository.save(client);
        return ClientMapper.toResponse(client, secretKey);
    }
}
