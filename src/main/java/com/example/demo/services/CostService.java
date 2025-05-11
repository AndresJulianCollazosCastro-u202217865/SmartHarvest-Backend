package com.example.demo.services;


import com.example.demo.dtos.CostDto;
import com.example.demo.entities.Cost;
import com.example.demo.entities.Crop;
import com.example.demo.interfaces.ICostService;
import com.example.demo.repositories.CostRepository;
import com.example.demo.repositories.CropRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostService implements ICostService {

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private CostRepository costRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CostDto registrarCostos(CostDto dto) {
        Cost cost = modelMapper.map(dto, Cost.class);
        Crop crop = cropRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado"));
        cost.setCrop(crop);
        Cost saved = costRepository.save(cost);
        return modelMapper.map(saved, CostDto.class);
    }

    @Override
    public List<CostDto> obtenerCostosPorCultivo(Long cropId) {
        List<Cost> costos = costRepository.findByCrop_Id(cropId);
        return costos.stream()
                .map(c -> modelMapper.map(c, CostDto.class))
                .collect(Collectors.toList());
    }
}
