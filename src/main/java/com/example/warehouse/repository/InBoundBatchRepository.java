package com.example.warehouse.repository;

import com.example.warehouse.entity.InBoundBatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InBoundBatchRepository extends JpaRepository<InBoundBatch,String> {
}
