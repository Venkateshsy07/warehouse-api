package com.example.warehouse.serviceimpl;

import com.example.warehouse.dto.request.InBoundShipmentRequest;
import com.example.warehouse.dto.response.InBoundShipmentResponse;
import com.example.warehouse.entity.InBoundShipment;
import com.example.warehouse.entity.Product;
import com.example.warehouse.entity.WareHouse;
import com.example.warehouse.exception.WareHouseNotFindByIdException;
import com.example.warehouse.mapper.InBoundShipmentMapper;
import com.example.warehouse.repository.InboundShipmentRepository;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.repository.WareHouseRepository;
import com.example.warehouse.service.InBoundShipmentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InboundShipmentServiceImpl implements InBoundShipmentService {



    private final InboundShipmentRepository inBoundShipmentRepository;
    private final InBoundShipmentMapper inBoundShipmentMapper;
    private final WareHouseRepository wareHouseRepository;
    private final ProductRepository productRepository;

    @Transactional
    @Override
    public InBoundShipmentResponse receiveProductInWareHouse(InBoundShipmentRequest request, String wareHouseId) {
        Product product = productRepository.findById(request.productDetails().productId())
                .orElse(null);

        if (product == null) {
            product = inBoundShipmentMapper.productToEntity(request.productDetails());
            product = productRepository.save(product);
        }

        WareHouse warehouse = wareHouseRepository.findById(wareHouseId)
                .orElseThrow(() -> new WareHouseNotFindByIdException("Warehouse not found!"));

        InBoundShipment inBoundShipment = inBoundShipmentMapper.toEntity(request, new InBoundShipment());
        inBoundShipment.setProduct(product);
        inBoundShipment.setWarehouse(warehouse);
        inBoundShipmentRepository.save(inBoundShipment);
        return inBoundShipmentMapper.toResponse(inBoundShipment);
    }
}