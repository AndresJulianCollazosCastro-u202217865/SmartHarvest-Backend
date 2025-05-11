package com.example.demo.entities;

import com.example.demo.security.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crop")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crop_id", nullable = false)
    private Long id;

    @Column(name = "crop_name", length = Integer.MAX_VALUE)
    private String cropName;

    @Column(name = "crop_type")
    private String cropType;

    @Column(name = "crop_ubication", length = Integer.MAX_VALUE)
    private String cropUbication;

    @Column(name = "crop_area")
    private Double cropArea;

    @Column(name = "crop_startDate", length = Integer.MAX_VALUE)
    private LocalDate startDate;

    @Column(name = "crop_endDate", length = Integer.MAX_VALUE)
    private LocalDate endDate;

    @Column(name = "next_crop_id")
    private Long nextCropId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public String getCropUbication() {
        return cropUbication;
    }

    public void setCropUbication(String cropUbication) {
        this.cropUbication = cropUbication;
    }

    public Double getCropArea() {
        return cropArea;
    }

    public void setCropArea(Double cropArea) {
        this.cropArea = cropArea;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getNextCropId() {
        return nextCropId;
    }

    public void setNextCropId(Long nextCropId) {
        this.nextCropId = nextCropId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*
 TODO [Reverse Engineering] create field to map the 'crop_type' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "crop_type", columnDefinition = "crop_type_enum")
    private Object cropType;
*/
}