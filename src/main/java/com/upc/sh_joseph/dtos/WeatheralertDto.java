package com.upc.sh_joseph.dtos;

import com.example.smartharvest.entities.WeatherAlertEstate;
import com.example.smartharvest.entities.WeatherAlertType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
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
}