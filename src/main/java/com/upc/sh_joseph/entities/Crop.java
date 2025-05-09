package com.upc.sh_joseph.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "crop")
public class Crop {
    @Id
    @Column(name = "crop_id", nullable = false)
    private Long id;

    @Column(name = "crop_name", length = Integer.MAX_VALUE)
    private String cropName;

    @Column(name = "crop_ubication", length = Integer.MAX_VALUE)
    private String cropUbication;

    @Column(name = "crop_area")
    private Double cropArea;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

/*
 TODO [Reverse Engineering] create field to map the 'crop_type' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "crop_type", columnDefinition = "crop_type_enum")
    private Object cropType;
*/
}