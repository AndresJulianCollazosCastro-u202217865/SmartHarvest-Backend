package com.example.demo.repositories;


import com.example.demo.entities.HistoricalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalDataRepository extends JpaRepository<HistoricalData, Long> {
}
