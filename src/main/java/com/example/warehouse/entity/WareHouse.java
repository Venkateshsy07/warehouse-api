package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "warehouse")
public class WareHouse {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "warehouse_Id", nullable = false, updatable = false)
    private String warehouseId;

    @Column(name = "wareHouse_name",nullable = false,updatable = false)
    private String warehouseName;

    @Column(name = "city",nullable = false,updatable = false)
    private String city;

    @Column(name = "landmark",nullable = false,updatable = false)
    private String landmark;

    @Column(name = "address",nullable = false,updatable = false)
    private String address;

@OneToMany(mappedBy ="warehouse")
    private List<Staff> staffs;

@OneToMany(mappedBy = "warehouse")
private List<Admin> admins;

}
