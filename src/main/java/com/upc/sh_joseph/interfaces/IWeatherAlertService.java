package com.upc.sh_joseph.interfaces;

import com.example.smartharvest.dtos.AlertReportDto;
import com.example.smartharvest.dtos.WeatheralertDto;
import com.example.smartharvest.entities.WeatherAlertEstate;
import com.example.smartharvest.entities.WeatherAlertType;

import java.time.LocalDateTime;
import java.util.List;

public interface IWeatherAlertService {
    public WeatheralertDto saveWeatherAlert(WeatheralertDto weatherAlertDto);
  //
    public List<WeatheralertDto> findVisibleAlertsByLocationAndOptionalTypeAndStatus(String location, WeatherAlertType type, WeatherAlertEstate status, Long userId);
  //

    public void updateAlertEstado(Long alertId, Long userId);

    public List<WeatheralertDto> findRecentVisibleAlertsByUser(Long userId, LocalDateTime fromDateTime);

    public void logicallyDeleteAlert(Long alertId, Long userId);

    public List<AlertReportDto> countAlertsByTypeInLocationAndUser(String location, Long userId);
}
