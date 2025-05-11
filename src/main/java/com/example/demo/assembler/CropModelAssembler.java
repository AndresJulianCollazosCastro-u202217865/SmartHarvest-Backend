package com.example.demo.assembler;

import com.example.demo.controllers.CropController;
import com.example.demo.dtos.CropDto;
import com.example.demo.entities.Crop;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CropModelAssembler implements RepresentationModelAssembler<CropDto, EntityModel<CropDto>> {
    @Override
    public EntityModel<CropDto> toModel(CropDto cropDto) {
        return EntityModel.of(cropDto,
                linkTo(methodOn(CropController.class).listarCultivos()).withSelfRel(),
                linkTo(methodOn(CropController.class).listarCultivos()).withRel("cultivos")
        );
    }
}
