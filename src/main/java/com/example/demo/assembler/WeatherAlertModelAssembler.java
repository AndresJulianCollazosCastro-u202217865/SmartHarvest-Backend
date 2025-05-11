package com.example.demo.assembler;

import com.example.demo.controllers.WeatherAlertController;
import com.example.demo.dtos.WeatheralertDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class WeatherAlertModelAssembler implements RepresentationModelAssembler<WeatheralertDto, EntityModel<WeatheralertDto>> {
    @Override
    public EntityModel<WeatheralertDto> toModel(WeatheralertDto dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(WeatherAlertController.class).listarAlertas()).withSelfRel(),
                linkTo(methodOn(WeatherAlertController.class).listarAlertas()).withRel("alertas")
        );
    }
}
