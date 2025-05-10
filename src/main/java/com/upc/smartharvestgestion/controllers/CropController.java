package com.upc.smartharvestgestion.controllers;

import com.upc.smartharvestgestion.dtos.CropDto;
import com.upc.smartharvestgestion.interfaces.ICropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CropController {
    @Autowired
    private ICropService cropService;

    @PostMapping("/cultivos")
    public ResponseEntity<CropDto> crearCultivo(@RequestBody CropDto cropDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cropService.crearCultivo(cropDto));
    }

    @GetMapping("/cultivos")
    public ResponseEntity<List<CropDto>> listarCultivos() {
        return ResponseEntity.ok(cropService.listarCultivos());
    }

    @PutMapping("/cultivos/{id}")
    public ResponseEntity<CropDto> actualizarCultivo(@PathVariable Long id, @RequestBody CropDto cropDto) {
        return ResponseEntity.ok(cropService.actualizarCultivo(id, cropDto));
    }

    @DeleteMapping("/cultivos/{id}")
    public ResponseEntity<Void> eliminarCultivo(@PathVariable Long id) {
        cropService.eliminarCultivo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cultivos/{cropId}/asignar-rotacion/{nextCropId}")
    public ResponseEntity<CropDto> asignarRotacion(@PathVariable Long cropId, @PathVariable Long nextCropId) {
        return ResponseEntity.ok(cropService.asignarRotacion(cropId, nextCropId));
    }

    @GetMapping("/cultivos/{cropId}/proxima-rotacion")
    public ResponseEntity<Long> obtenerProximaRotacion(@PathVariable Long cropId) {
        return ResponseEntity.ok(cropService.obtenerProximaRotacion(cropId));
    }
}
