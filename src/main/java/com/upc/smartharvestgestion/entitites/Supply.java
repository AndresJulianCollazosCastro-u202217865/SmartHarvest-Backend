package com.upc.smartharvestgestion.entitites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
