package com.example.warehouse.mapper;

import com.example.warehouse.dto.request.ProductUnitRequest;
import com.example.warehouse.dto.response.ProductUnitResponse;
import com.example.warehouse.entity.Product;
import com.example.warehouse.entity.ProductUnit;
import org.springframework.stereotype.Component;

@Component
public class ProductUnitMapper {

    public ProductUnit productToEntity(ProductUnitRequest unitRequest) {

        ProductUnit productUnit = new ProductUnit();

        productUnit.setLocation(productUnit.getLocation());

        return productUnit;
    }


    private ProductUnitResponse productUnitResponse(ProductUnit productUnit) {

        return new ProductUnitResponse(
                productUnit.getUnitId(),
                productUnit.getLocation()
//                productUnit.getInBoundBatch(),
//                productUnit.getInboundShipment(),
//                productUnit.getProduct()
        );
    }

}