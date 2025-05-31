package com.example.warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "staffs")
public class Staff extends User{


    @ManyToOne
    @JoinColumn(name = "warehouse_Id")
    private WareHouse warehouse;
}
