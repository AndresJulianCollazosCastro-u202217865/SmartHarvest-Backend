package com.example.demo.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
public class CropDto implements Serializable {
    Long id;
    String cropName;
    String cropType;
    String cropUbication;
    Double cropArea;
    LocalDate startDate;
    LocalDate endDate;
    Long nextCropId;

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
}