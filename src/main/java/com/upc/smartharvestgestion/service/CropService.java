package com.upc.smartharvestgestion.service;

import com.upc.smartharvestgestion.dtos.CropDto;
import com.upc.smartharvestgestion.entitites.Crop;
import com.upc.smartharvestgestion.interfaces.ICropService;
import com.upc.smartharvestgestion.repository.CropRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CropService implements ICropService {

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CropDto crearCultivo(CropDto dto) {
        Crop crop = modelMapper.map(dto, Crop.class);
        crop = cropRepository.save(crop);
        return modelMapper.map(crop, CropDto.class);
    }

    @Override
    public List<CropDto> listarCultivos() {
        return cropRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, CropDto.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public CropDto obtenerCultivoPorId(Long id) {
//        Crop crop = cropRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado"));
//        return modelMapper.map(crop, CropDto.class);
//    }

    @Override
    public CropDto actualizarCultivo(Long id, CropDto dto) {
        Crop crop = cropRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado"));
        modelMapper.map(dto, crop);
        return modelMapper.map(cropRepository.save(crop), CropDto.class);
    }

    @Override
    public void eliminarCultivo(Long id) {
        if (!cropRepository.existsById(id)) {
            throw new RuntimeException("Cultivo no existe");
        }
        cropRepository.deleteById(id);
    }

    @Override
    public CropDto asignarRotacion(Long cropId, Long nextCropId) {
        Crop crop = cropRepository.findById(cropId)
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado"));

        crop.setNextCropId(nextCropId);

        Crop actualizado = cropRepository.save(crop);

        return modelMapper.map(actualizado, CropDto.class);
    }

    @Override
    public Long obtenerProximaRotacion(Long cropId) {
        Crop crop = cropRepository.findById(cropId)
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado"));

        return crop.getNextCropId();
    }
}
