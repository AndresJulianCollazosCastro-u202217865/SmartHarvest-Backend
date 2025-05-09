package com.upc.sh_joseph.services;

import com.example.smartharvest.dtos.AlertReportDto;
import com.example.smartharvest.dtos.WeatheralertDto;
import com.example.smartharvest.entities.WeatherAlertEstate;
import com.example.smartharvest.entities.WeatherAlertType;
import com.example.smartharvest.entities.Weatheralert;
import com.example.smartharvest.interfaces.IWeatherAlertService;
import com.example.smartharvest.repositories.UserRepository;
import com.example.smartharvest.repositories.WeatherAlertRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherAlertService implements IWeatherAlertService {
    @Autowired
    private WeatherAlertRepository weatherAlertRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public WeatheralertDto saveWeatherAlert(WeatheralertDto weatherAlertDto) {
        Weatheralert weatherAlert = modelMapper.map(weatherAlertDto, Weatheralert.class);
        Weatheralert saved = weatherAlertRepository.save(weatherAlert);
        return modelMapper.map(saved, WeatheralertDto.class);
    }

    @Override
    @Transactional
    public void updateAlertEstado(Long alertId, Long userId) {
        weatherAlertRepository.updateAlertEstado(alertId, userId, WeatherAlertEstate.LEIDA);
    }

    //
    @Override
    @Transactional
    public List<WeatheralertDto> findVisibleAlertsByLocationAndOptionalTypeAndStatus(String location, WeatherAlertType type, WeatherAlertEstate status, Long userId) {
        List<Weatheralert> weatheralerts = weatherAlertRepository.findVisibleAlertsByLocationAndOptionalTypeAndStatus(location, type, status, userId);
        return weatheralerts.stream()
                .map(weatherAlert -> modelMapper.map(weatherAlert, WeatheralertDto.class))
                .collect(Collectors.toList());
        /*return weatherAlertRepository.findVisibleAlertsByLocationAndOptionalTypeAndStatus(location, type, status, userId)
                .stream()
                .map(alert -> modelMapper.map(alert, WeatheralertDto.class))
                .collect(Collectors.toList());*/
    }
    //

    @Override
    @Transactional
    public List<WeatheralertDto> findRecentVisibleAlertsByUser(Long userId, LocalDateTime fromDateTime) {
        return weatherAlertRepository.findRecentVisibleAlertsByUser(userId, fromDateTime)
                .stream()
                .map(alert -> modelMapper.map(alert, WeatheralertDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void logicallyDeleteAlert(Long alertId, Long userId) {
        weatherAlertRepository.logicallyDeleteAlert(alertId, userId);
    }

    @Override
    @Transactional
    public List<AlertReportDto> countAlertsByTypeInLocationAndUser(String location, Long userId) {
        return weatherAlertRepository.countAlertsByTypeInLocationAndUser(location, userId);
    }
}
