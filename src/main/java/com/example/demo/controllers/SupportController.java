package com.example.demo.controllers;

import com.example.demo.dtos.SupportDto;
import com.example.demo.interfaces.ISupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SupportController {
    @Autowired
    private ISupportService supportService;

    @PostMapping("/support")
    public ResponseEntity<SupportDto> grabarSupport(@RequestBody SupportDto supportDto) {
        return ResponseEntity.ok(supportService.grabarSupport(supportDto));
    }
}
