package com.example.demo.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supply")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supply_id", nullable = false)
    private Long id;

    @Column(name = "supply_name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "supply_quantity")
    private int quantity;

    @Column(name = "supply_unit", length = Integer.MAX_VALUE)
    private String unit;

    @Column(name = "supply_description", length = Integer.MAX_VALUE)
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
}

