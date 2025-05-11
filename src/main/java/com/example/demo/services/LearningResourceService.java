package com.example.demo.services;

import com.example.demo.dtos.LearningResourceDto;
import com.example.demo.entities.Learningresource;
import com.example.demo.interfaces.ILearningResourceService;
import com.example.demo.repositories.LearningResourceRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearningResourceService implements ILearningResourceService {

    @Autowired
    private LearningResourceRepositorio learningResourceRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LearningResourceDto grabarLearningResource(LearningResourceDto learningResource) {
        Learningresource learningresource = modelMapper.map(learningResource, Learningresource.class);
        Learningresource guardar = learningResourceRepositorio.save(learningresource);
        return modelMapper.map(guardar, LearningResourceDto.class);
    }

    @Override
    public List<LearningResourceDto> obtenerLearningResourceCategoria(String lrCategory) {
        return learningResourceRepositorio.findLearningResourceByLrCategoryContaining(lrCategory)
                .stream().map(learningResource -> modelMapper.map(learningResource, LearningResourceDto.class)).collect(Collectors.toList());
    }


    @Override
    public List<LearningResourceDto> listarLearningResource() {
        return learningResourceRepositorio.findAll()
                .stream().map(learningResource -> modelMapper.map(learningResource, LearningResourceDto.class)).collect(Collectors.toList());

    }
}
