package com.example.demo.controllers;


import com.example.demo.assembler.RecommendationModelAssembler;
import com.example.demo.dtos.RecommendationDto;
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
    public ResponseEntity<RecommendationDto> saveRecommendation(@RequestBody RecommendationDto recommendationDto) {
        return ResponseEntity.ok(recommendationService.saveRecommendation(recommendationDto));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<RecommendationDto>> getRecommendation() {
        return ResponseEntity.ok(recommendationService.getRecommendation()) ;
    }
}
