package com.example.demo.dtos;


import com.example.demo.entities.Crop;
import com.example.demo.entities.Weatheralert;
import com.example.demo.security.dtos.UserDto;
import com.example.demo.security.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;



@AllArgsConstructor
@NoArgsConstructor
public class HistoricalDataDto implements Serializable {
    Long historicalDataId;
    UserDto user;
    LocalDate hDate;
    CropDto crop;
    WeatheralertDto weatheralert;

    public Long getHistoricalDataId() {
        return historicalDataId;
    }

    public void setHistoricalDataId(Long historicalDataId) {
        this.historicalDataId = historicalDataId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public LocalDate gethDate() {
        return hDate;
    }

    public void sethDate(LocalDate hDate) {
        this.hDate = hDate;
    }

    public WeatheralertDto getWeatheralert() {
        return weatheralert;
    }

    public void setWeatheralert(WeatheralertDto weatheralert) {
        this.weatheralert = weatheralert;
    }

    public CropDto getCrop() {
        return crop;
    }

    public void setCrop(CropDto crop) {
        this.crop = crop;
    }
}