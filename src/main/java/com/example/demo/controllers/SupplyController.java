package com.example.demo.controllers;


import com.example.demo.dtos.SupplyDto;
import com.example.demo.interfaces.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SmartHarvest/supplies")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true",
        exposedHeaders = "Authorization")
public class SupplyController {

    @Autowired
    private ISupplyService supplyService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<SupplyDto> crearInsumo(@RequestBody SupplyDto supplyDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplyService.crearInsumo(supplyDto));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<SupplyDto>> listarInsumos() {
        return ResponseEntity.ok(supplyService.listarInsumos());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<SupplyDto> actualizarInsumo(@PathVariable Long id, @RequestBody SupplyDto supplyDto) {
        return ResponseEntity.ok(supplyService.actualizarInsumo(id, supplyDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Void> eliminarInsumo(@PathVariable Long id) {
        supplyService.eliminarInsumo(id);
        return ResponseEntity.noContent().build();
    }

}
