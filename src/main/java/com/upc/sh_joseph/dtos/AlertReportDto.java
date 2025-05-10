package com.upc.sh_joseph.dtos;

import com.upc.sh_joseph.entities.WeatherAlertType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertReportDto  implements Serializable {
    private WeatherAlertType type;
    private Long total;
}
