package com.upc.smartharvestgestion.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.upc.smartharvestgestion.entitites.Supply}
 */
@Getter
@Setter
@Value
public class SupplyDto implements Serializable {
    Long id;
    String name;
    int quantity;
    String unit;
    String description;
    @NotNull
    CropDto crop;
}