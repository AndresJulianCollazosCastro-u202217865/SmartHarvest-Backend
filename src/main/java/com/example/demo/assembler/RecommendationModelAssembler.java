package com.example.demo.assembler;

import com.example.demo.controllers.RecommendationController;
import com.example.demo.dtos.RecommendationDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RecommendationModelAssembler implements RepresentationModelAssembler<RecommendationDto, EntityModel<RecommendationDto>> {

    @Override
    public EntityModel<RecommendationDto> toModel(RecommendationDto dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(RecommendationController.class).getRecommendation()).withSelfRel(),
                linkTo(methodOn(RecommendationController.class).getRecommendation()).withRel("recomendaciones")
        );
    }
}
