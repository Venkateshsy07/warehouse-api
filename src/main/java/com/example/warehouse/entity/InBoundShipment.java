
package com.example.warehouse.entity;

import com.example.warehouse.enums.InBoundStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "in_bound_shipment")
public class InBoundShipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shipment_id", nullable = false, updatable = false)
    private String shipmentId;

    @Column(name = "seller_id", nullable = false, updatable = false)
    private String sellerId;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "status",nullable = false)
    private InBoundStatus status;

    @Column(name = "quantity",nullable = false,updatable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WareHouse warehouse;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
