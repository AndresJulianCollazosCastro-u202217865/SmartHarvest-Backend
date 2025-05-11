package com.example.demo.dtos;

import com.example.demo.entities.WeatherAlertEstate;
import com.example.demo.entities.WeatherAlertType;
import com.example.demo.security.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
public class WeatheralertDto implements Serializable {
    Long id;
    UserDto userid;
    String waTitle;
    String waDescription;
    LocalDateTime waDate;
    WeatherAlertType waType;
    WeatherAlertEstate estado;
    Boolean visible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserid() {
        return userid;
    }

    public void setUserid(UserDto userid) {
        this.userid = userid;
    }

    public String getWaTitle() {
        return waTitle;
    }

    public void setWaTitle(String waTitle) {
        this.waTitle = waTitle;
    }

    public String getWaDescription() {
        return waDescription;
    }

    public void setWaDescription(String waDescription) {
        this.waDescription = waDescription;
    }

    public LocalDateTime getWaDate() {
        return waDate;
    }

    public void setWaDate(LocalDateTime waDate) {
        this.waDate = waDate;
    }

    public WeatherAlertType getWaType() {
        return waType;
    }

    public void setWaType(WeatherAlertType waType) {
        this.waType = waType;
    }

    public WeatherAlertEstate getEstado() {
        return estado;
    }

    public void setEstado(WeatherAlertEstate estado) {
        this.estado = estado;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}