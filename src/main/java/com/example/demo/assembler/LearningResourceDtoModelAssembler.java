package com.example.demo.assembler;

import com.example.demo.controllers.LearningResourceController;
import com.example.demo.dtos.LearningResourceDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LearningResourceDtoModelAssembler implements RepresentationModelAssembler<LearningResourceDto, EntityModel<LearningResourceDto>> {

    @Override
    public EntityModel<LearningResourceDto> toModel(LearningResourceDto dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(LearningResourceController.class).listarLearningResource()).withSelfRel(),
                linkTo(methodOn(LearningResourceController.class).listarLearningResource()).withRel("recursos")
        );
    }
}