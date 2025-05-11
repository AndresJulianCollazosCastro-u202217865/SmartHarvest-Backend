package com.example.demo.interfaces;


import com.example.demo.dtos.AlertReportDto;
import com.example.demo.dtos.WeatheralertDto;
import com.example.demo.entities.WeatherAlertEstate;
import com.example.demo.entities.WeatherAlertType;

import java.time.LocalDateTime;
import java.util.List;

public interface IWeatherAlertService {
  WeatheralertDto saveWeatherAlert(WeatheralertDto weatherAlertDto);

  List<WeatheralertDto> getWeatherAlerts();

  List<WeatheralertDto> findVisibleAlertsByOptionalTypeAndStatus(WeatherAlertType type, WeatherAlertEstate status, Long userId);

  void updateAlertEstado(Long alertId, Long userId);

  List<WeatheralertDto> findRecentVisibleAlertsByUser(Long userId, LocalDateTime fromDateTime);

  void logicallyDeleteAlert(Long alertId, Long userId);

  List<AlertReportDto> countAlertsByTypeAndUser(Long userId);
}

