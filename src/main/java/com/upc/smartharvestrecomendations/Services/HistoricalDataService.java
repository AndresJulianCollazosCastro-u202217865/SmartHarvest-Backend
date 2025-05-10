package com.upc.smartharvestrecomendations.Services;

import com.upc.smartharvestrecomendations.Dtos.HistoricalDataDto;
import com.upc.smartharvestrecomendations.Entities.HistoricalData;
import com.upc.smartharvestrecomendations.Interfaces.IHistoricalDataService;
import com.upc.smartharvestrecomendations.Repositories.HistoricalDataRepository;
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
