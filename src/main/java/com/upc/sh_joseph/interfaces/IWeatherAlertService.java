package com.upc.sh_joseph.interfaces;

import com.upc.sh_joseph.dtos.AlertReportDto;
import com.upc.sh_joseph.dtos.WeatheralertDto;
import com.upc.sh_joseph.entities.WeatherAlertEstate;
import com.upc.sh_joseph.entities.WeatherAlertType;

import java.time.LocalDateTime;
import java.util.List;

public interface IWeatherAlertService {
  WeatheralertDto saveWeatherAlert(WeatheralertDto weatherAlertDto);

  List<WeatheralertDto> findVisibleAlertsByOptionalTypeAndStatus(WeatherAlertType type, WeatherAlertEstate status, Long userId);

  void updateAlertEstado(Long alertId, Long userId);

  List<WeatheralertDto> findRecentVisibleAlertsByUser(Long userId, LocalDateTime fromDateTime);

  void logicallyDeleteAlert(Long alertId, Long userId);

  List<AlertReportDto> countAlertsByTypeAndUser(Long userId);
}

