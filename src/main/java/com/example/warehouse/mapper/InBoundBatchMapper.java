package com.example.warehouse.mapper;

import com.example.warehouse.dto.request.InBoundBatchRequest;
import com.example.warehouse.dto.response.InBoundBatchResponse;
import com.example.warehouse.entity.InBoundBatch;
import org.springframework.stereotype.Controller;

@Controller
public class InBoundBatchMapper {

    public InBoundBatch toEntity(InBoundBatchRequest source, InBoundBatch target){
        if (source == null) return null;
        target.setCountOfRejectedUnit(source.countOfRejectedUnit());
        target.setCountOfAcceptedUnit(source.countOfAcceptedUnit());
        return target;
    }

    public InBoundBatchResponse toResponse(InBoundBatch batch){
        if (batch == null) return null;
        return new InBoundBatchResponse(
                batch.getBatchId(),
                batch.getCountOfRejectedUnit(),
                batch.getCountOfAcceptedUnit()
        );
    }
}