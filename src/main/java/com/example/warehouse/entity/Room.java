package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
@Table(name = "room")
public class Room {

    @ManyToOne
    private WareHouse warehouse;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "room_id",nullable = false,updatable = false)
    private String roomId;

    @Column(name = "name",nullable = false)
    private String name;
}
