package com.example.warehouse.serviceimpl;

import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;
import com.example.warehouse.entity.Block;
import com.example.warehouse.entity.Rack;
import com.example.warehouse.entity.RackedBlock;
import com.example.warehouse.entity.Room;
import com.example.warehouse.exception.BlockNotFoundByIdException;
import com.example.warehouse.mapper.RackMapper;
import com.example.warehouse.repository.BlockRepository;
import com.example.warehouse.repository.RackRepository;
import com.example.warehouse.service.RackService;
import com.example.warehouse.shared.BarCodeGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RackServiceImpl implements RackService {

    private final RackRepository rackRepository;
    private final BlockRepository blockRepository;
    private final RackMapper rackMapper;


    @Override
    public RackResponse createRoom(RackRequest rackRequest,String userId) {

        Block block = blockRepository.findById(userId).orElseThrow(() -> new BlockNotFoundByIdException("Block not found with id: " + userId));
        if(block instanceof RackedBlock rackedBlock){
            Rack rack = rackMapper.toEntity(rackRequest, new Rack());
            rack.setRackedblock(rackedBlock);
            blockRepository.save(block);
            rackRepository.save(rack);
            return rackMapper.toResponse(rack);
        } else {
            throw new BlockNotFoundByIdException("Block is not of type RackedBlock with id: " + block.getBlockId());
        }
    }
    @Override
    public byte[] generateRackBarCode(String rackId) {
        Rack rack = rackRepository.findById(rackId).orElseThrow(() -> new BlockNotFoundByIdException("Rack not found with id: " + rackId));

    RackedBlock block=rack.getRackedblock();
        Room room= block.getRoom();
        String content =String.format("""
                {"roomId": "%s",
                "blockId": "%s",
                "rackid": "%s",
                }""", room.getRoomId(), block.getBlockId(), rack.getRackId());
        byte [] bytes=null;
        try {
            bytes = BarCodeGenerator.generateQRCodeImage(content, 200, 200);
            return bytes;
        } catch (Exception e) {
           System.out.println("");
        }
        return bytes;
    }

}
