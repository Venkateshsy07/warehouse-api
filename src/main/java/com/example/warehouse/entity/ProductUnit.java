package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "product_unit")
public class ProductUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "unit_id", updatable = false, nullable = false)
    private String unitId;

    @Column(name = "location", length = 2000)
    private String location;

    @ManyToOne
    @JoinColumn(name = "inbound_shipment_id")
    private InBoundShipment inBoundShipment;

    @ManyToOne
    @JoinColumn(name = "inbound_batch_id")
    private InBoundBatch batch;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}