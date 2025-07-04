package com.example.demo.services;


import com.example.demo.dtos.RecommendationDto;
import com.example.demo.entities.Crop;
import com.example.demo.entities.Recommendation;
import com.example.demo.interfaces.IRecommendationService;
import com.example.demo.repositories.CropRepository;
import com.example.demo.repositories.RecommendationRepository;
import com.example.demo.security.entities.User;
import com.example.demo.security.repositories.UserRepository;
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
    private ModelMapper modelMapper;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private RecommendationRepository recommendationRepository;


    @Transactional
    public RecommendationDto saveRecommendation(RecommendationDto dto) {
        Recommendation recommendation = modelMapper.map(dto, Recommendation.class);

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Crop crop = cropRepository.findById(dto.getCropId())
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado"));

        recommendation.setUser(user);
        recommendation.setCrop(crop);

        Recommendation saved = recommendationRepository.save(recommendation);
        return modelMapper.map(saved, RecommendationDto.class);
    }


    @Override
    public List<RecommendationDto> getRecommendation() {
        List<Recommendation> recommendations = recommendationRepository.findAll();
        return recommendations.stream().map((element) -> modelMapper.map(element, RecommendationDto.class)).collect(Collectors.toList());
    }


    public List<RecommendationDto> findByCropId(Long id) {
        List<Recommendation> recomendaciones = recommendationRepository.findByCropId(id);
        return recomendaciones.stream()
            .map(rec -> modelMapper.map(rec, RecommendationDto.class))
            .collect(Collectors.toList());
    }
}
