package com.example.demo.entities;


import com.example.demo.security.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
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

    /*
 TODO [Reverse Engineering] create field to map the 'wa_type' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "wa_type", columnDefinition = "weather_alert_type_enum")
    private Object waType;
*/
}