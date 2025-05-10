package com.upc.smartharvestgestion.entitites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
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
    private com.upc.smartharvestgestion.entitites.User user;

/*
 TODO [Reverse Engineering] create field to map the 'crop_type' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "crop_type", columnDefinition = "crop_type_enum")
    private Object cropType;
*/
}