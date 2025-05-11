package com.example.demo.dtos;


import com.example.demo.entities.Crop;
import com.example.demo.entities.Weatheralert;
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
    User user;
    LocalDate hDate;
    Crop crop;
    Weatheralert weatheralert;

    public Long getHistoricalDataId() {
        return historicalDataId;
    }

    public void setHistoricalDataId(Long historicalDataId) {
        this.historicalDataId = historicalDataId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate gethDate() {
        return hDate;
    }

    public void sethDate(LocalDate hDate) {
        this.hDate = hDate;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Weatheralert getWeatheralert() {
        return weatheralert;
    }

    public void setWeatheralert(Weatheralert weatheralert) {
        this.weatheralert = weatheralert;
    }
}