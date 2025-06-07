package com.example.demo.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 */
@NoArgsConstructor
@AllArgsConstructor
public class SupplyDto implements Serializable {
    Long id;
    String name;
    int quantity;
    String unit;
    String description;
    @NotNull
    CropDto crop;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CropDto getCrop() {
        return crop;
    }

    public void setCrop(CropDto crop) {
        this.crop = crop;
    }
}