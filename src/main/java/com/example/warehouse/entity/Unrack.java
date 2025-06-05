package com.example.warehouse.entity;

import com.example.warehouse.enums.BlockType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Unrack {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String unrackId;

    @Column(name = "height",nullable = false)
    private double height;

    @Column(name = "length",nullable = false)
    private double length;

    @Column(name = "breadth",nullable = false)
    private double breadth;

}