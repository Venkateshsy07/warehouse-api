package com.example.warehouse.entity;

import com.example.warehouse.enums.BlockType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Rack")
public class Rack {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String rackId;

    @Column(name = "height",nullable = false)
    private double height;

    @Column(name = "length",nullable = false)
    private double length;

    @Column(name = "breadth",nullable = false)
    private double breadth;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;

    @ManyToOne
    @JoinColumn(name = "racked_block_id")
    private RackedBlock rackedblock;

}