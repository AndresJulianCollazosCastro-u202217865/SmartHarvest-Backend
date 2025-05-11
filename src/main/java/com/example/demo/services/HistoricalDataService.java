package com.example.demo.services;


import com.example.demo.dtos.HistoricalDataDto;
import com.example.demo.entities.HistoricalData;
import com.example.demo.interfaces.IHistoricalDataService;
import com.example.demo.repositories.HistoricalDataRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HistoricalDataService implements IHistoricalDataService {
    @Autowired
    private HistoricalDataRepository historicalDataRepository;
    @Autowired
    private ModelMapper modelMapper;

    public HistoricalDataDto getHistoricalData(HistoricalDataDto historicalDataDto) {
        HistoricalData historicalData = modelMapper.map(historicalDataDto, HistoricalData.class);
        HistoricalData save = historicalDataRepository.save(historicalData);
        return modelMapper.map(save, HistoricalDataDto.class);
    }
}
