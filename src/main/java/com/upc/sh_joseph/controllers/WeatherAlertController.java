package com.upc.sh_joseph.controllers;

import com.example.smartharvest.dtos.AlertReportDto;
import com.example.smartharvest.dtos.WeatheralertDto;
import com.example.smartharvest.entities.WeatherAlertEstate;
import com.example.smartharvest.entities.WeatherAlertType;
import com.example.smartharvest.interfaces.IWeatherAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/alert")
public class WeatherAlertController {
    @Autowired
    private IWeatherAlertService weatherAlertService;

    @PostMapping
    public ResponseEntity<WeatheralertDto> saveWeatherAlert(@RequestBody WeatheralertDto weatherAlertDto) {
        return ResponseEntity.ok(weatherAlertService.saveWeatherAlert(weatherAlertDto));
    }

    //
    // US21: Consulta de Alertas por Ubicación y Tipo (opcional)
    @GetMapping("/filter")
    public ResponseEntity<List<WeatheralertDto>> findVisibleAlertsByLocationAndOptionalTypeAndStatus(
            @RequestParam String location,
            @RequestParam(required = false) WeatherAlertType type, // null para "TODAS"
            @RequestParam(required = false) WeatherAlertEstate status,
            @RequestParam Long userId) {
        return ResponseEntity.ok(weatherAlertService.findVisibleAlertsByLocationAndOptionalTypeAndStatus(location, type, status, userId));
    }
    //

    //US13: Consulta de Alertas Recientes desde una Fecha Específica
    @GetMapping("/recent")
    public ResponseEntity<List<WeatheralertDto>> findRecentVisibleAlertsByUser(
            @RequestParam Long userId,
            @RequestParam String fromDate) {
        // Convertir la fecha (sin hora) a LocalDateTime con la hora 00:00
        LocalDateTime dateTime = LocalDate.parse(fromDate).atStartOfDay();
        return ResponseEntity.ok(weatherAlertService.findRecentVisibleAlertsByUser(userId, dateTime));
    }

    // US24: Listar alertas visibles por usuario
    @DeleteMapping("/logical-delete/{userId}/{alertId}")
    public ResponseEntity<Void> logicallyDeleteAlert(@PathVariable Long userId, @PathVariable Long alertId) {
        weatherAlertService.logicallyDeleteAlert(alertId, userId);
        return ResponseEntity.noContent().build();
    }

    // Reporte: Número de alertas por tipo en una ciudad para un usuario
    @GetMapping("/report")
    public ResponseEntity<List<AlertReportDto>> countAlertsByTypeInLocationAndUser(
            @RequestParam String location,
            @RequestParam Long userId) {
        return ResponseEntity.ok(weatherAlertService.countAlertsByTypeInLocationAndUser(location, userId));
    }

    // US08: Marcar alerta como leída
    @PutMapping("/mark-as-read/{userId}/{alertId}")
    public ResponseEntity<Void> updateAlertEstado(@PathVariable Long userId, @PathVariable Long alertId) {
        weatherAlertService.updateAlertEstado(alertId, userId);
        return ResponseEntity.noContent().build();
    }

}
