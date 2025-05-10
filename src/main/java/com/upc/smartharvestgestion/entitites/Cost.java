package com.upc.smartharvestgestion.entitites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cost")
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost_concept", length = Integer.MAX_VALUE)
    private String concept;

    @Column(name = "cost_amount")
    private Double amount;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cropId")
    private Crop crop;
}

