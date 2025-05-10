package com.upc.smartharvestgestion.interfaces;

import com.upc.smartharvestgestion.dtos.CostDto;

import java.util.List;

public interface ICostService {
    public CostDto registrarCostos(CostDto dto);
    public List<CostDto> obtenerCostosPorCultivo(Long cropId);
}
