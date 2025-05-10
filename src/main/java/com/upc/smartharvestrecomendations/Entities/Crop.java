package com.upc.smartharvestrecomendations.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crops")
public class Crop {
    @Id
    @Column(name = "crop_id", nullable = false)
    private Long cropId;

    @Column(name = "crop_name", length = Integer.MAX_VALUE)
    private String cropName;

    @Column(name = "crop_ubication", length = Integer.MAX_VALUE)
    private String cropUbication;

    @Column(name = "crop_area")
    private Double cropArea;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "crop_type", columnDefinition = "crop_type_enum")
    private Object cropType;
}
