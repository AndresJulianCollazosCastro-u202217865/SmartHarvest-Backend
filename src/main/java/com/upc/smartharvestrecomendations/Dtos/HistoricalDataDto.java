package com.upc.smartharvestrecomendations.Dtos;

import com.upc.smartharvestrecomendations.Entities.Crop;
import com.upc.smartharvestrecomendations.Entities.User;
import com.upc.smartharvestrecomendations.Entities.WeatherAlert;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.upc.smartharvestrecomendations.Entities.HistoricalData}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricalDataDto implements Serializable {
    Long historicalDataId;
    User user;
    LocalDate hDate;
    Crop crop;
    WeatherAlert weatheralert;
}