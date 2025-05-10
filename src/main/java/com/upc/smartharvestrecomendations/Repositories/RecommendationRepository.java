package com.upc.smartharvestrecomendations.Repositories;

import com.upc.smartharvestrecomendations.Entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
