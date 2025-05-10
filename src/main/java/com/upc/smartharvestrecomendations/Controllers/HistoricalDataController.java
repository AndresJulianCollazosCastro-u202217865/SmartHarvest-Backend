package com.upc.smartharvestrecomendations.Controllers;

import com.upc.smartharvestrecomendations.Dtos.HistoricalDataDto;
import com.upc.smartharvestrecomendations.Entities.HistoricalData;
import com.upc.smartharvestrecomendations.Interfaces.IHistoricalDataService;
import com.upc.smartharvestrecomendations.Services.HistoricalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
