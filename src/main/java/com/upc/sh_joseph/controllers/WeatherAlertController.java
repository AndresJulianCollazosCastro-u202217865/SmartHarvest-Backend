package com.upc.sh_joseph.controllers;

import com.upc.sh_joseph.dtos.AlertReportDto;
import com.upc.sh_joseph.dtos.WeatheralertDto;
import com.upc.sh_joseph.entities.WeatherAlertEstate;
import com.upc.sh_joseph.entities.WeatherAlertType;
import com.upc.sh_joseph.interfaces.IWeatherAlertService;
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

    // US15: Consulta de Alertas por Tipo y Estado
    @GetMapping("/filter")
    public ResponseEntity<List<WeatheralertDto>> findVisibleAlertsByOptionalTypeAndStatus(
            @RequestParam(required = false) WeatherAlertType type,
            @RequestParam(required = false) WeatherAlertEstate status,
            @RequestParam Long userId) {
        return ResponseEntity.ok(weatherAlertService.findVisibleAlertsByOptionalTypeAndStatus(type, status, userId));
    }

    //US16: Consulta de Alertas Recientes desde una Fecha Específica
    @GetMapping("/recent")
    public ResponseEntity<List<WeatheralertDto>> findRecentVisibleAlertsByUser(
            @RequestParam Long userId,
            @RequestParam String fromDate) {
        LocalDateTime dateTime = LocalDate.parse(fromDate).atStartOfDay();
        return ResponseEntity.ok(weatherAlertService.findRecentVisibleAlertsByUser(userId, dateTime));
    }

    // US17: Eliminación Lógica de Alertas
    @DeleteMapping("/logical-delete/{userId}/{alertId}")
    public ResponseEntity<Void> logicallyDeleteAlert(@PathVariable Long userId, @PathVariable Long alertId) {
        weatherAlertService.logicallyDeleteAlert(alertId, userId);
        return ResponseEntity.noContent().build();
    }

    //US18: Generación de Reporte de Alertas por Tipo de Alerta
    @GetMapping("/report")
    public ResponseEntity<List<AlertReportDto>> countAlertsByTypeForUser(@RequestParam Long userId) {
        return ResponseEntity.ok(weatherAlertService.countAlertsByTypeAndUser(userId));
    }

    // US08: Marcar alerta como leída
    @PutMapping("/mark-as-read/{userId}/{alertId}")
    public ResponseEntity<Void> updateAlertEstado(@PathVariable Long userId, @PathVariable Long alertId) {
        weatherAlertService.updateAlertEstado(alertId, userId);
        return ResponseEntity.noContent().build();
    }
}

