package com.example.demo.services;


import com.example.demo.dtos.SupplyDto;
import com.example.demo.entities.Supply;
import com.example.demo.interfaces.ISupplyService;
import com.example.demo.repositories.CropRepository;
import com.example.demo.repositories.SupplyRepository;
import com.example.demo.security.repositories.UserRepository;
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
