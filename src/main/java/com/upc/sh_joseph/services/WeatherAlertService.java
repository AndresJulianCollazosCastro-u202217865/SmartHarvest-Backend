package com.upc.sh_joseph.services;

import com.upc.sh_joseph.dtos.AlertReportDto;
import com.upc.sh_joseph.dtos.WeatheralertDto;
import com.upc.sh_joseph.entities.User;
import com.upc.sh_joseph.entities.WeatherAlertEstate;
import com.upc.sh_joseph.entities.WeatherAlertType;
import com.upc.sh_joseph.entities.Weatheralert;
import com.upc.sh_joseph.interfaces.IWeatherAlertService;
import com.upc.sh_joseph.repositories.UserRepository;
import com.upc.sh_joseph.repositories.WeatherAlertRepository;
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

    // 🔄 Actualizado: ya no recibe location
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

    // 🔄 Actualizado: ya no recibe location
    @Override
    @Transactional
    public List<AlertReportDto> countAlertsByTypeAndUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return weatherAlertRepository.countAlertsByTypeAndUser(userId);
    }
}

