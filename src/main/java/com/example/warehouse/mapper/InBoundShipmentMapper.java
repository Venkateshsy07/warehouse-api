package com.example.warehouse.mapper;

import com.example.warehouse.dto.request.InBoundShipmentRequest;
import com.example.warehouse.dto.request.ProductRequest;
import com.example.warehouse.dto.response.InBoundShipmentResponse;
import com.example.warehouse.dto.response.ProductResponse;
import com.example.warehouse.entity.InBoundShipment;
import com.example.warehouse.entity.Product;
import org.springframework.stereotype.Controller;

@Controller
public class InBoundShipmentMapper {

    public InBoundShipment toEntity(InBoundShipmentRequest source, InBoundShipment target) {

        target.setSellerId(source.sellerId());
        target.setStatus(source.status());
        target.setQuantity(source.quantity());
        target.setProduct(productToEntity(source.productDetails()));
        return target;
    }

    public InBoundShipmentResponse toResponse(InBoundShipment inBoundShipment) {

        return new InBoundShipmentResponse(
                inBoundShipment.getShipmentId(),
                inBoundShipment.getSellerId(),
                inBoundShipment.getStatus(),
                inBoundShipment.getQuantity(),
                inBoundShipment.getCreatedAt().toEpochMilli(),
                productToResponse(inBoundShipment.getProduct())
        );
    }

    public Product productToEntity(ProductRequest productRequest) {

        Product product = new Product();
        product.setProductId(productRequest.productId());
        product.setTitle(productRequest.productTitle());
        product.setWeight(productRequest.productWeight());
        product.setLength(productRequest.productLength());
        product.setHeight(productRequest.productHeight());
        product.setWidth(productRequest.productWidth());
        product.setMaterialType(productRequest.materialType());
        product.setCareInstruction(productRequest.careInstruction());
        product.setPrice(productRequest.productPrice());

        return product;
    }

    private ProductResponse productToResponse(Product product) {

        return new ProductResponse(
                product.getProductId(),
                product.getTitle(),
                product.getWeight(),
                product.getLength(),
                product.getHeight(),
                product.getWidth(),
                product.getMaterialType(),
                product.getCareInstruction(),
                product.getPrice()
        );
    }
}