package com.upc.smartharvestgestion.controllers;

import com.upc.smartharvestgestion.dtos.CostDto;
import com.upc.smartharvestgestion.interfaces.ICostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/costos")
public class CostController {
    @Autowired
    private ICostService costService;

    @PostMapping("/api/costos")
    public ResponseEntity<CostDto> registrarCosto(@RequestBody CostDto costDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(costService.registrarCostos(costDto));
    }

    @GetMapping("/por-cultivo/{cropId}")
    public ResponseEntity<List<CostDto>> listarCostosPorCultivo(@PathVariable Long cropId) {
        return ResponseEntity.ok(costService.obtenerCostosPorCultivo(cropId));
    }
}
