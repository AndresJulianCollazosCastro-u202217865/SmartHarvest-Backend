package com.example.demo.service;


import com.example.demo.dtos.SupportDto;
import com.example.demo.entities.Support;
import com.example.demo.interfaces.ISupportService;
import com.example.demo.repositories.SupportRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SupportService implements ISupportService {

    @Autowired
    private SupportRepositorio supportRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupportDto grabarSupport(SupportDto supportDto) {
        Support support = modelMapper.map(supportDto, Support.class);
        Support guardar = supportRepositorio.save(support);
        return modelMapper.map(guardar, SupportDto.class);

    }
}
