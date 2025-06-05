package com.example.warehouse.mapper;

import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;
import com.example.warehouse.entity.Rack;
import org.springframework.stereotype.Controller;

@Controller
public class RackMapper {

    public Rack toEntity(RackRequest source, Rack target){
        if (source == null) {
            return target;
        }
        if (target == null) {
            target = new Rack();
        }
        target.setHeight(source.height());
        target.setLength(source.length());
        target.setBreadth(source.breadth());
        return target;
    }

    public RackResponse toResponse(Rack rack){
        if (rack == null) {
            return null;
        }
        return new RackResponse(
                rack.getRackId(),
                rack.getHeight(),
                rack.getLength(),
                rack.getBreadth()
        );
    }
}