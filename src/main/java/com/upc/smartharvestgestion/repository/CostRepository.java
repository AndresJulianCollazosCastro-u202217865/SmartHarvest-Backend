package com.upc.smartharvestgestion.repository;

import com.upc.smartharvestgestion.entitites.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostRepository extends JpaRepository<Cost, Long> {
    List<Cost> findByCrop_Id(Long cropId);
}