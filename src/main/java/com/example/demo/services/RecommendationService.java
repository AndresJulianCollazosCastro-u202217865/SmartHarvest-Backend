package com.example.demo.services;


import com.example.demo.dtos.RecommendationDto;
import com.example.demo.entities.Recommendation;
import com.example.demo.interfaces.IRecommendationService;
import com.example.demo.repositories.RecommendationRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecommendationService implements IRecommendationService {
    @Autowired
    private RecommendationRepository recommendationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public RecommendationDto saveRecommendation(RecommendationDto recommendationDto) {
        Recommendation recommendation = modelMapper.map(recommendationDto, Recommendation.class);
        Recommendation save = recommendationRepository.save(recommendation);
        return modelMapper.map(save, RecommendationDto.class);
    }

    @Override
    public List<RecommendationDto> getRecommendation() {
        List<Recommendation> recommendations = recommendationRepository.findAll();
        return recommendations.stream().map((element) -> modelMapper.map(element, RecommendationDto.class)).collect(Collectors.toList());
    }
}
