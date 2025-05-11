package com.example.demo.repositories;


import com.example.demo.entities.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostRepository extends JpaRepository<Cost, Long> {
    List<Cost> findByCrop_Id(Long cropId);
}