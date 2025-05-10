package com.upc.smartharvestgestion.service;

import com.upc.smartharvestgestion.dtos.SupplyDto;
import com.upc.smartharvestgestion.entitites.Supply;
import com.upc.smartharvestgestion.interfaces.ISupplyService;
import com.upc.smartharvestgestion.repository.CropRepository;
import com.upc.smartharvestgestion.repository.SupplyRepository;
import com.upc.smartharvestgestion.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplyService implements ISupplyService {

    @Autowired
    private SupplyRepository supplyRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupplyDto crearInsumo(SupplyDto dto) {
        Supply supply = modelMapper.map(dto, Supply.class);
        supply = supplyRepository.save(supply);
        return modelMapper.map(supply, SupplyDto.class);
    }

    @Override
    public List<SupplyDto> listarInsumos() {
        return supplyRepository.findAll()
                .stream()
                .map(s -> modelMapper.map(s, SupplyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SupplyDto obtenerInsumoPorId(Long id) {
        Supply supply = supplyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado"));
        return modelMapper.map(supply, SupplyDto.class);
    }

    @Override
    public SupplyDto actualizarInsumo(Long id, SupplyDto dto) {
        Supply supply = supplyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado"));
        modelMapper.map(dto, supply); // actualiza campos
        return modelMapper.map(supplyRepository.save(supply), SupplyDto.class);
    }

    @Override
    public void eliminarInsumo(Long id) {
        if (!supplyRepository.existsById(id)) {
            throw new RuntimeException("Insumo no existe");
        }
        supplyRepository.deleteById(id);
    }
}
