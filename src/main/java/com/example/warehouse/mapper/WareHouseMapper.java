package com.example.warehouse.mapper;

import com.example.warehouse.dto.request.WareHouseRequest;
import com.example.warehouse.dto.response.WareHouseResponse;
import com.example.warehouse.entity.WareHouse;
import org.springframework.stereotype.Controller;

@Controller
public class  WareHouseMapper {

    public static WareHouse warehouseToEntity(WareHouseRequest request, WareHouse target) {
        if (target == null) {
            target = new WareHouse();
        }
        target.setWarehouseName(request.warehouseName());
        target.setCity(request.city());
        target.setLandmark(request.landmark());
        target.setAddress(request.address());
        return target;
    }

    public static WareHouseResponse warehouseToResponse(WareHouse wareHouse) {
        if (wareHouse == null) {
            return null;
        }
        return new WareHouseResponse(
            wareHouse.getWarehouseId(),
            wareHouse.getWarehouseName(),
            wareHouse.getCity(),
            wareHouse.getAddress(),
            wareHouse.getLandmark()
        );
    }

}
