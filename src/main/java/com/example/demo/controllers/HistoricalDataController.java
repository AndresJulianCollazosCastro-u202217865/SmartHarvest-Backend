package com.example.demo.controllers;


import com.example.demo.dtos.HistoricalDataDto;
import com.example.demo.services.HistoricalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SmartHarvest/historical-data")
public class HistoricalDataController {
    @Autowired
    private HistoricalDataService historicalDataService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<HistoricalDataDto> addHistoricalData(@RequestBody HistoricalDataDto historicalDataDto) {
        return ResponseEntity.ok(historicalDataService.getHistoricalData(historicalDataDto));
    }
}
