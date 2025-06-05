package com.example.warehouse.repository;

import com.example.warehouse.entity.InBoundShipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InboundShipmentRepository extends JpaRepository<InBoundShipment,String> {

}
