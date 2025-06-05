
package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "title", nullable = false, updatable = false)
    private String title;

    @Column(name = "weight")
    private double weight;

    @Column(name = "length")
    private double length;

    @Column(name = "height")
    private double height;

    @Column(name = "width")
    private double width;

    @Column(name = "material_type", nullable = false)
    private String materialType;

    @Column(name = "care_instruction", nullable = false, updatable = false, length = 2000)
    private String careInstruction;

    @Column(name = "price", nullable = false)
    private double price;
}
