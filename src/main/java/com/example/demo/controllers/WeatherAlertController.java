package com.example.demo.controllers;


import com.example.demo.assembler.WeatherAlertModelAssembler;
import com.example.demo.dtos.AlertReportDto;
import com.example.demo.dtos.WeatheralertDto;
import com.example.demo.entities.WeatherAlertEstate;
import com.example.demo.entities.WeatherAlertType;
import com.example.demo.interfaces.IWeatherAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/SmartHarvest/alertas")
public class WeatherAlertController {
    @Autowired
    private IWeatherAlertService weatherAlertService;

    @Autowired
    private WeatherAlertModelAssembler assembler;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<WeatheralertDto> saveWeatherAlert(@RequestBody WeatheralertDto weatherAlertDto) {
        return ResponseEntity.ok(weatherAlertService.saveWeatherAlert(weatherAlertDto));
    }


    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public CollectionModel<EntityModel<WeatheralertDto>> listarAlertas() {
        var dtos = weatherAlertService.getWeatherAlerts();
        var models = dtos.stream()
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(models,
                linkTo(methodOn(WeatherAlertController.class).listarAlertas()).withSelfRel());
    }

    // US15: Consulta de Alertas por Tipo y Estado
    @GetMapping("/filter")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<WeatheralertDto>> findVisibleAlertsByOptionalTypeAndStatus(
            @RequestParam(required = false) WeatherAlertType type,
            @RequestParam(required = false) WeatherAlertEstate status,
            @RequestParam Long userId) {
        return ResponseEntity.ok(weatherAlertService.findVisibleAlertsByOptionalTypeAndStatus(type, status, userId));
    }

    //US16: Consulta de Alertas Recientes desde una Fecha Específica
    @GetMapping("/recent")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<WeatheralertDto>> findRecentVisibleAlertsByUser(
            @RequestParam Long userId,
            @RequestParam String fromDate) {
        LocalDateTime dateTime = LocalDate.parse(fromDate).atStartOfDay();
        return ResponseEntity.ok(weatherAlertService.findRecentVisibleAlertsByUser(userId, dateTime));
    }

    // US17: Eliminación Lógica de Alertas
    @DeleteMapping("/logical-delete/{userId}/{alertId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> logicallyDeleteAlert(@PathVariable Long userId, @PathVariable Long alertId) {
        weatherAlertService.logicallyDeleteAlert(alertId, userId);
        return ResponseEntity.noContent().build();
    }

    //US18: Generación de Reporte de Alertas por Tipo de Alerta
    @GetMapping("/report")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<AlertReportDto>> countAlertsByTypeForUser(@RequestParam Long userId) {
        return ResponseEntity.ok(weatherAlertService.countAlertsByTypeAndUser(userId));
    }

    // US08: Marcar alerta como leída
    @PutMapping("/mark-as-read/{userId}/{alertId}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Void> updateAlertEstado(@PathVariable Long userId, @PathVariable Long alertId) {
        weatherAlertService.updateAlertEstado(alertId, userId);
        return ResponseEntity.noContent().build();
    }
}

