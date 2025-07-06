package com.example.demo.controllers;


import com.example.demo.assembler.CropModelAssembler;
import com.example.demo.dtos.CropDto;
import com.example.demo.entities.Crop;
import com.example.demo.interfaces.ICropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/SmartHarvest/cultivos")
@CrossOrigin(origins  = "${ip.frontend}",
        allowCredentials = "true",
        exposedHeaders = "Authorization")
public class CropController {
    @Autowired
    private ICropService cropService;
    @Autowired
    private CropModelAssembler cropModelAssembler;



    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<CropDto> crearCultivo(@RequestBody CropDto cropDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cropService.crearCultivo(cropDto));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public CollectionModel<EntityModel<CropDto>> listarCultivos() {
        var dtos = cropService.listarCultivos();
        var models = dtos.stream()
                .map(dto -> cropModelAssembler.toModel(dto))
                .toList();
        return CollectionModel.of(models,
                linkTo(methodOn(CropController.class).listarCultivos()).withSelfRel());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<CropDto> actualizarCultivo(@PathVariable Long id, @RequestBody CropDto cropDto) {
        return ResponseEntity.ok(cropService.actualizarCultivo(id, cropDto));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Void> eliminarCultivo(@PathVariable Long id) {
        cropService.eliminarCultivo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{cropId}/rotacion/{nextCropId}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<CropDto> asignarRotacion(@PathVariable Long cropId, @PathVariable Long nextCropId) {
        return ResponseEntity.ok(cropService.asignarRotacion(cropId, nextCropId));
    }

    @GetMapping("/{cropId}/rotacion")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Long> obtenerProximaRotacion(@PathVariable Long cropId) {
        return ResponseEntity.ok(cropService.obtenerProximaRotacion(cropId));
    }
}
