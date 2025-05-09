package com.upc.sh_joseph.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "weatheralerts")
public class Weatheralert {
    @Id
    @Column(name = "wa_alert_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @Column(name = "wa_title", length = Integer.MAX_VALUE)
    private String waTitle;

    @Column(name = "wa_description", length = Integer.MAX_VALUE)
    private String waDescription;

    @Column(name = "wa_date")
    private LocalDateTime waDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "wa_type", nullable = false)
    private WeatherAlertType waType;

    @Enumerated(EnumType.STRING)
    @Column(name = "wa_estate", nullable = false)
    private WeatherAlertEstate estado = WeatherAlertEstate.NUEVA;

    @Column(name = "visible")
    private Boolean visible = true;

/*
 TODO [Reverse Engineering] create field to map the 'wa_type' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "wa_type", columnDefinition = "weather_alert_type_enum")
    private Object waType;
*/
}