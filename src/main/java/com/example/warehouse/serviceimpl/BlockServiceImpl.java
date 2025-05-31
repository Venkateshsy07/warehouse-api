package com.example.warehouse.serviceimpl;

import com.example.warehouse.dto.request.BlockRequest;
import com.example.warehouse.dto.response.BlockResponse;
import com.example.warehouse.entity.Block;
import com.example.warehouse.entity.Rack;
import com.example.warehouse.entity.Room;
import com.example.warehouse.entity.Unrack;
import com.example.warehouse.exception.RoomNotFoundByIdException;
import com.example.warehouse.exception.UnSupportedBlockTypeException;
import com.example.warehouse.mapper.BlockMapper;
import com.example.warehouse.repository.BlockRepository;
import com.example.warehouse.repository.RoomRepository;
import com.example.warehouse.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BlockMapper blockMapper;

    @Override
    public BlockResponse createBlock(BlockRequest request, String roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RoomNotFoundByIdException("Room is Not Exist!!"));
        Block block = switch (request.type()) {
            case RACK -> blockMapper.toEntity(request, new Rack());
            case UNRACK -> blockMapper.toEntity(request, new Unrack());
            default -> throw new UnSupportedBlockTypeException(request.type() + " is Not Available!!");
        };
        block.setRoom(room);
        roomRepository.save(room);
        blockRepository.save(block);
        return blockMapper.toResponse(block);
    }


    }

