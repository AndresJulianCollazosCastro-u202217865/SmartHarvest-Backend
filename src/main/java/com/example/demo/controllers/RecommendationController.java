package com.example.demo.controllers;


import com.example.demo.assembler.RecommendationModelAssembler;
import com.example.demo.dtos.RecommendationDto;
import com.example.demo.entities.Crop;
import com.example.demo.entities.Recommendation;
import com.example.demo.repositories.CropRepository;
import com.example.demo.repositories.RecommendationRepository;
import com.example.demo.security.entities.User;
import com.example.demo.security.repositories.UserRepository;
import com.example.demo.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/SmartHarvest/recommendations")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true",
        exposedHeaders = "Authorization")
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private RecommendationModelAssembler assembler;
    



    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public RecommendationDto saveRecommendation(@RequestBody RecommendationDto dto) {
        System.out.println("Datos recibidos: " + dto.getUserId());
        System.out.println("Datos recibidos: " + dto.getCropId());

        RecommendationDto resultDto = recommendationService.saveRecommendation(dto);
        return resultDto;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<RecommendationDto>> getRecommendation() {
        return ResponseEntity.ok(recommendationService.getRecommendation()) ;
    }
    
    @GetMapping("/cultivo/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<RecommendationDto>> getRecomendacionesPorCultivo(@PathVariable Long id) {
        List<RecommendationDto> recomendaciones = recommendationService.findByCropId(id);
        return ResponseEntity.ok(recomendaciones);
    }
}
