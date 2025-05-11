package com.example.demo.controllers;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class DashboardController {
    @GetMapping("/dashboard")
    public RepresentationModel<?> dashboard() {
        RepresentationModel<?> model = new RepresentationModel<>();

        model.add(linkTo(methodOn(CropController.class)
                .listarCultivos()).withRel("cultivos"));
        model.add(linkTo(methodOn(WeatherAlertController.class)
                .listarAlertas()).withRel("alertas"));
        model.add(linkTo(methodOn(RecommendationController.class)
                .getRecommendation()).withRel("recommendation"));
        model.add(linkTo(methodOn(LearningResourceController.class)
                .listarLearningResource()).withRel("learning"));
        return model;
    }
}

