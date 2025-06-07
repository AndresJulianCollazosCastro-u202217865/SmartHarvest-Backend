package com.example.demo.controllers;

import com.example.demo.assembler.LearningResourceDtoModelAssembler;
import com.example.demo.dtos.LearningResourceDto;
import com.example.demo.interfaces.ILearningResourceService;
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
@RequestMapping("/SmartHarvest/learning-resources")
public class LearningResourceController {

    @Autowired
    private ILearningResourceService learningResourceService;

    @Autowired
    private LearningResourceDtoModelAssembler assembler;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LearningResourceDto> grabarLearningResource(@RequestBody LearningResourceDto learningResourceDto) {
        return ResponseEntity.ok(learningResourceService.grabarLearningResource(learningResourceDto));
    }

    @GetMapping("/{lrCategoria}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<LearningResourceDto>> obtenerLearningResourceCategoria(@PathVariable String lrCategoria) {
        return ResponseEntity.ok(learningResourceService.obtenerLearningResourceCategoria(lrCategoria));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public CollectionModel<EntityModel<LearningResourceDto>> listarLearningResource() {
        var dtos = learningResourceService.listarLearningResource();
        var models = dtos.stream()
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(models,
                linkTo(methodOn(LearningResourceController.class).listarLearningResource()).withSelfRel());
    }
}
