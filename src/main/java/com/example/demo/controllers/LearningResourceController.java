package com.example.demo.controllers;

import com.example.demo.dtos.LearningResourceDto;
import com.example.demo.interfaces.ILearningResourceService;
import com.example.demo.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LearningResourceController {
    @Autowired
    private ILearningResourceService learningResourceService;

    @PostMapping("/learningResource")
    public ResponseEntity<LearningResourceDto> grabarLearningResource(@RequestBody LearningResourceDto learningResourceDto) {
        return ResponseEntity.ok(learningResourceService.grabarLearningResource(learningResourceDto));
    }

    @GetMapping("/learningResourceCategoria")
    public ResponseEntity<List<LearningResourceDto>> obtenerLearningResourceCategoria(String lrCategoria) {
        return ResponseEntity.ok(learningResourceService.obtenerLearningResourceCategoria(lrCategoria));
    }

    @GetMapping("/lista/learningResource")
    public ResponseEntity<List<LearningResourceDto>> listarLearningResource() {
        return ResponseEntity.ok(learningResourceService.listarLearningResource());
    }




}
