package com.upc.smartharvestgestion.interfaces;

import com.upc.smartharvestgestion.dtos.CropDto;

import java.util.List;

public interface ICropService {
    // CRUD de cultivos (Gestión de Cultivos)
    public CropDto crearCultivo(CropDto dto);

    public List<CropDto> listarCultivos();

    // ya que no lo he usado: public CropDto obtenerCultivoPorId(Long id);

    public CropDto actualizarCultivo(Long id, CropDto dto);

    public void eliminarCultivo(Long id);

    // Planificación de Rotación de Cultivos
    public CropDto asignarRotacion(Long cropId, Long nextCropId);

    public Long obtenerProximaRotacion(Long cropId);
}
