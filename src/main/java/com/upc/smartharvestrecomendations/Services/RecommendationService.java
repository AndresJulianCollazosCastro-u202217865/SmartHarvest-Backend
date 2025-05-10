package com.upc.smartharvestrecomendations.Services;

import com.upc.smartharvestrecomendations.Dtos.RecommendationDto;
import com.upc.smartharvestrecomendations.Entities.Recommendation;
import com.upc.smartharvestrecomendations.Interfaces.IRecommendationService;
import com.upc.smartharvestrecomendations.Repositories.RecommendationRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RecommendationService implements IRecommendationService {
    @Autowired
    private RecommendationRepository recommendationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public RecommendationDto getRecommendation(RecommendationDto recommendationDto) {
        Recommendation recommendation = modelMapper.map(recommendationDto, Recommendation.class);
        Recommendation save = recommendationRepository.save(recommendation);
        return modelMapper.map(save, RecommendationDto.class);
    }
}
