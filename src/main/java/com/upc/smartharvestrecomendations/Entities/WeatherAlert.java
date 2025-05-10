package com.upc.smartharvestrecomendations.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "weatherAlerts")
public class WeatherAlert {
    @Id
    @Column(name = "wa_alert_id", nullable = false)
    private Long waId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "wa_title", length = Integer.MAX_VALUE)
    private String waTitle;

    @Column(name = "wa_description", length = Integer.MAX_VALUE)
    private String waDescription;

    @Column(name = "wa_date")
    private LocalDate waDate;

    @Column(name = "wa_type", columnDefinition = "weather_alert_type_enum")
    private Object waType;
}
