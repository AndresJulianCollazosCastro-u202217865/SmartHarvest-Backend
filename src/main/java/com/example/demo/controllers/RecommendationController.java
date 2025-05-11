package com.example.demo.controllers;


import com.example.demo.assembler.RecommendationModelAssembler;
import com.example.demo.dtos.RecommendationDto;
import com.example.demo.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/recomendaciones")
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private RecommendationModelAssembler assembler;

    @PostMapping("/recommendation")
    public ResponseEntity<RecommendationDto> saveRecommendation(@RequestBody RecommendationDto recommendationDto) {
        return ResponseEntity.ok(recommendationService.saveRecommendation(recommendationDto));
    }

    @GetMapping
    public CollectionModel<EntityModel<RecommendationDto>> getRecommendation() {
        var dtos = recommendationService.getRecommendation();
        var models = dtos.stream()
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(models,
                linkTo(methodOn(RecommendationController.class).getRecommendation()).withSelfRel());
    }
}
