package com.example.demo.dtos;

import lombok.*;

import java.io.Serializable;



@NoArgsConstructor
@AllArgsConstructor
public class CostDto implements Serializable {
    Long id;
    String concept;
    Double amount;
    CropDto crop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CropDto getCrop() {
        return crop;
    }

    public void setCrop(CropDto crop) {
        this.crop = crop;
    }
}