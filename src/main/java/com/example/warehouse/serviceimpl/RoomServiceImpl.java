package com.example.warehouse.serviceimpl;
import com.example.warehouse.mapper.RoomMapper;
import com.example.warehouse.dto.request.RoomRequest;
import com.example.warehouse.dto.response.RoomResponse;
import com.example.warehouse.entity.Room;
import com.example.warehouse.entity.WareHouse;
import com.example.warehouse.exception.WareHouseNotFindByIdException;
import com.example.warehouse.repository.RoomRepository;
import com.example.warehouse.repository.WareHouseRepository;
import com.example.warehouse.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public RoomResponse createRoom(RoomRequest request, String warehouseId) {
        WareHouse wareHouse = wareHouseRepository.findById(warehouseId).orElseThrow(() -> new WareHouseNotFindByIdException("WareHouse Not Find!!"));
        Room room = roomMapper.toEntity(request, new Room());
        room.setWarehouse(wareHouse);
        roomRepository.save(room);
        return roomMapper.toResponse(room);
    }
}

