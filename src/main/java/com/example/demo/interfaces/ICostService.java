package com.example.demo.interfaces;



import com.example.demo.dtos.CostDto;

import java.util.List;

public interface ICostService {
    public CostDto registrarCostos(CostDto dto);
    public List<CostDto> obtenerCostosPorCultivo(Long cropId);
}
