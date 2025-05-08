package com.example.demo.interfaces;

import com.example.demo.dtos.LearningResourceDto;
import com.example.demo.entities.Learningresource;

import java.util.List;

public interface ILearningResourceService {
    public LearningResourceDto grabarLearningResource(LearningResourceDto learningResource);
    public List<LearningResourceDto> obtenerLearningResourceCategoria(String lrCategory);
    public List<LearningResourceDto> listarLearningResource();
}
