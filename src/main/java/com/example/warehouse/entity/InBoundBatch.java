package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "in_bound_batch")
public class InBoundBatch {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "batch_id", nullable = false, updatable = false)
    private String batchId;

    @Column(name = "count_of_rejected_unit", nullable = false)
    private int countOfRejectedUnit;

    @Column(name = "count_of_accepted_unit", nullable = false)
    private int countOfAcceptedUnit;

    @OneToMany(mappedBy = "batch")
    List<ProductUnit> productUnitList;

}