package com.example.demo.interfaces;


import com.example.demo.dtos.RecommendationDto;

import java.util.List;

public interface IRecommendationService {
    RecommendationDto saveRecommendation(RecommendationDto recommendationDto);
    List<RecommendationDto> getRecommendation();
    
}
