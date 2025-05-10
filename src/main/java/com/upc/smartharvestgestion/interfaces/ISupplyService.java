package com.upc.smartharvestgestion.interfaces;

import com.upc.smartharvestgestion.dtos.SupplyDto;

import java.util.List;

public interface ISupplyService {
    public SupplyDto crearInsumo(SupplyDto dto);
    public List<SupplyDto> listarInsumos();
    public SupplyDto obtenerInsumoPorId(Long id);
    public SupplyDto actualizarInsumo(Long id, SupplyDto dto);
    public void eliminarInsumo(Long id);
}
