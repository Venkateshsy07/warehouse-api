package com.example.warehouse.repository;

import com.example.warehouse.entity.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductUnitRepository extends JpaRepository<ProductUnit, String> {
    // Additional query methods can be defined here if needed
}
