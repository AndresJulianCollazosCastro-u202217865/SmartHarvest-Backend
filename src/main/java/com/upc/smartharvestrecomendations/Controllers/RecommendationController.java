package com.upc.smartharvestrecomendations.Controllers;

import com.upc.smartharvestrecomendations.Dtos.RecommendationDto;
import com.upc.smartharvestrecomendations.Services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/recommendations")
    public ResponseEntity<RecommendationDto> getRecommendation(@RequestBody RecommendationDto recommendationDto) {
        return ResponseEntity.ok(recommendationService.getRecommendation(recommendationDto));
    }
}
