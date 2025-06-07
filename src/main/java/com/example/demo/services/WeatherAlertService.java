package com.example.demo.services;


import com.example.demo.dtos.AlertReportDto;
import com.example.demo.dtos.WeatheralertDto;
import com.example.demo.entities.WeatherAlertEstate;
import com.example.demo.entities.WeatherAlertType;
import com.example.demo.entities.Weatheralert;
import com.example.demo.interfaces.IWeatherAlertService;
import com.example.demo.repositories.WeatherAlertRepository;
import com.example.demo.security.dtos.UserDto;
import com.example.demo.security.entities.User;
import com.example.demo.security.repositories.UserRepository;
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
        if (weatherAlert.getWaDate() == null) {
            weatherAlert.setWaDate(LocalDateTime.now());
        }
        Long userId = weatherAlertDto.getUserid().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        weatherAlert.setUserid(user);
        Weatheralert saved = weatherAlertRepository.save(weatherAlert);
        WeatheralertDto savedDto = modelMapper.map(saved, WeatheralertDto.class);
        UserDto userDto = modelMapper.map(saved.getUserid(), UserDto.class);
        savedDto.setUserid(userDto);

        return savedDto;
    }

    @Override
    public List<WeatheralertDto> getWeatherAlerts() {
        List<Weatheralert> weatherAlerts = weatherAlertRepository.findAll();
        return weatherAlerts.stream().map((element) -> modelMapper.map(element, WeatheralertDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateAlertEstado(Long alertId, Long userId) {
        weatherAlertRepository.updateAlertEstado(alertId, userId, WeatherAlertEstate.LEIDA);
    }

    @Override
    @Transactional
    public List<WeatheralertDto> findVisibleAlertsByOptionalTypeAndStatus(WeatherAlertType type, WeatherAlertEstate status, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        String location = user.getUserLocation(); // usamos su única ubicación registrada

        List<Weatheralert> weatheralerts = weatherAlertRepository.findVisibleAlertsByOptionalTypeAndStatus(type, status, userId);

        return weatheralerts.stream()
                .map(alert -> modelMapper.map(alert, WeatheralertDto.class))
                .collect(Collectors.toList());
    }

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
    public List<AlertReportDto> countAlertsByTypeAndUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return weatherAlertRepository.countAlertsByTypeAndUser(userId);
    }
}

