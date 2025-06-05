package com.example.warehouse.service;

import com.example.warehouse.dto.request.ClientRequest;
import com.example.warehouse.dto.response.ClientResponse;

public interface ClientService {
  ClientResponse registerClient(ClientRequest request);
}
