package com.example.warehouse.serviceimpl;

import com.example.warehouse.dto.request.WareHouseRequest;
import com.example.warehouse.dto.response.WareHouseResponse;
import com.example.warehouse.entity.Admin;
import com.example.warehouse.entity.User;
import com.example.warehouse.entity.WareHouse;

import com.example.warehouse.exception.InvalidUserRole;
import com.example.warehouse.exception.UserNotFoundWithid;
import com.example.warehouse.mapper.UserMapper;
import com.example.warehouse.mapper.WareHouseMapper;
import com.example.warehouse.repository.UserRepository;
import com.example.warehouse.repository.WareHouseRepository;
import com.example.warehouse.service.WareHouseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WareHouseServiceImpl implements WareHouseService {


    private final WareHouseRepository wareHouseRepository;
    private final UserRepository userRepository;
    private final WareHouseMapper wareHouseMapper = new WareHouseMapper();

    @Override
    public WareHouseResponse addWareHouse( WareHouseRequest wareHouseRequest, String userId) {
        // 1. Check if user exists
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundWithid("User not found: " + userId));

        // 2. Check if user is admin
        if (!(user instanceof Admin admin)) {
            throw new InvalidUserRole("User is not an admin: " + userId);
        }

        // 3. Check if this admin already has a warehouse
        if (admin.getWarehouse() != null) {
            throw new InvalidUserRole("This admin already has a warehouse and cannot create another.");
        }

        // 4. Map request to entity and set admin
        WareHouse wareHouseEntity = wareHouseMapper.warehouseToEntity(wareHouseRequest, new WareHouse());
        admin.setWarehouse(wareHouseEntity);

        // 5. Save warehouse and admin, then return response
        wareHouseRepository.save(wareHouseEntity);
        userRepository.save(admin);
        return wareHouseMapper.warehouseToResponse(wareHouseEntity);
    }



}