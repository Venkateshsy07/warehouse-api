package com.example.warehouse.controller;

import com.example.warehouse.dto.request.ClientRequest;
import com.example.warehouse.dto.response.ClientResponse;
import com.example.warehouse.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class ClientController {

    private  final ClientService clientService;
    @PostMapping("/client/register")
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientRequest) {
        ClientResponse clientResponse = clientService.registerClient(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).header(HttpHeaders.CONTENT_TYPE).body(clientResponse);
    }
}
