package com.example.demo.controllers;


import com.example.demo.dtos.HistoricalDataDto;
import com.example.demo.services.HistoricalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HistoricalDataController {
    @Autowired
    private HistoricalDataService historicalDataService;

    @GetMapping("/historicalData")
    public ResponseEntity<HistoricalDataDto> getHistoricalData(@RequestBody HistoricalDataDto historicalDataDto) {
        return ResponseEntity.ok(historicalDataService.getHistoricalData(historicalDataDto));
    }
}
