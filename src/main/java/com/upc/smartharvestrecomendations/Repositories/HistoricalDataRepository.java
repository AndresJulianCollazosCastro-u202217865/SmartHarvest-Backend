package com.upc.smartharvestrecomendations.Repositories;

import com.upc.smartharvestrecomendations.Entities.HistoricalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalDataRepository extends JpaRepository<HistoricalData, Long> {
}
