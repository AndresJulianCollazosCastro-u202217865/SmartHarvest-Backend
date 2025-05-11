package com.example.demo.dtos;

import com.example.demo.entities.WeatherAlertType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
public class AlertReportDto implements Serializable {
    private WeatherAlertType type;
    private Long total;

    public AlertReportDto(WeatherAlertType type, Long total) {
        this.type = type;
        this.total = total;
    }

    public WeatherAlertType getType() {
        return type;
    }

    public void setType(WeatherAlertType type) {
        this.type = type;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
