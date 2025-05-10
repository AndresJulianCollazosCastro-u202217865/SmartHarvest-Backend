package com.upc.smartharvestrecomendations.Interfaces;

import com.upc.smartharvestrecomendations.Dtos.RecommendationDto;

public interface IRecommendationService {
    public RecommendationDto getRecommendation(RecommendationDto recommendationDto);
}
