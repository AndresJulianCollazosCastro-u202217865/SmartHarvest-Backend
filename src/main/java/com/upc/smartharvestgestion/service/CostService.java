package com.upc.smartharvestgestion.service;

import com.upc.smartharvestgestion.dtos.CostDto;
import com.upc.smartharvestgestion.entitites.Cost;
import com.upc.smartharvestgestion.entitites.Crop;
import com.upc.smartharvestgestion.interfaces.ICostService;
import com.upc.smartharvestgestion.repository.CostRepository;
import com.upc.smartharvestgestion.repository.CropRepository;
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
