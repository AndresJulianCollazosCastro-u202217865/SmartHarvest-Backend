package com.example.demo.controllers;


import com.example.demo.dtos.SupplyDto;
import com.example.demo.interfaces.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insumos")
public class SupplyController {

    @Autowired
    private ISupplyService supplyService;

    @PostMapping("/insumos")
    public ResponseEntity<SupplyDto> crearInsumo(@RequestBody SupplyDto supplyDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplyService.crearInsumo(supplyDto));
    }

    @GetMapping("/insumos")
    public ResponseEntity<List<SupplyDto>> listarInsumos() {
        return ResponseEntity.ok(supplyService.listarInsumos());
    }

    @PutMapping("/insumos/{id}")
    public ResponseEntity<SupplyDto> actualizarInsumo(@PathVariable Long id, @RequestBody SupplyDto supplyDto) {
        return ResponseEntity.ok(supplyService.actualizarInsumo(id, supplyDto));
    }

    @DeleteMapping("/insumos/{id}")
    public ResponseEntity<Void> eliminarInsumo(@PathVariable Long id) {
        supplyService.eliminarInsumo(id);
        return ResponseEntity.noContent().build();
    }

}
