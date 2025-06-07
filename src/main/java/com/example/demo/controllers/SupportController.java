package com.example.demo.controllers;

import com.example.demo.dtos.SupportDto;
import com.example.demo.interfaces.ISupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SmartHarvest/support")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true",
        exposedHeaders = "Authorization")
public class SupportController {
    @Autowired
    private ISupportService supportService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<SupportDto> grabarSupport(@RequestBody SupportDto supportDto) {
        return ResponseEntity.ok(supportService.grabarSupport(supportDto));
    }
}
