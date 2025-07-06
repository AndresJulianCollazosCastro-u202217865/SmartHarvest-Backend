package com.example.demo.controllers;

import com.example.demo.dtos.CostDto;
import com.example.demo.interfaces.ICostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SmartHarvest/costos")
@CrossOrigin(origins  = "${ip.frontend}",
        allowCredentials = "true",
        exposedHeaders = "Authorization")
public class CostController {
    @Autowired
    private ICostService costService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CostDto> registrarCosto(@RequestBody CostDto costDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(costService.registrarCostos(costDto));
    }

    @GetMapping("/por-cultivo/{cropId}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<CostDto>> listarCostosPorCultivo(@PathVariable Long cropId) {
        return ResponseEntity.ok(costService.obtenerCostosPorCultivo(cropId));
    }
}
