package com.example.demo.entities;


import com.example.demo.security.dtos.UserDto;
import com.example.demo.security.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historicalData")
public class HistoricalData {
    @Id
    @Column(name = "historicalId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historicalDataId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "hDate", nullable = false)
    private LocalDate hDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cropId", nullable = false)
    private Crop crop;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "waId", nullable = false)
    private Weatheralert weatheralert;

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
