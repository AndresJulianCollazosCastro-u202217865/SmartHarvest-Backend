package com.example.demo.repositories;


import com.example.demo.dtos.RecommendationDto;
import com.example.demo.entities.Recommendation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
	List<Recommendation> findByCropId(Long cropId);
}
