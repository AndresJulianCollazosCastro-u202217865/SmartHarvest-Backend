package com.upc.smartharvestgestion.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.upc.smartharvestgestion.entitites.Crop}
 */
@Getter
@Setter
@Value
public class CropDto implements Serializable {
    Long id;
    String cropName;
    String cropType;
    String cropUbication;
    Double cropArea;
    LocalDate startDate;
    LocalDate endDate;
    Long nextCropId;
}