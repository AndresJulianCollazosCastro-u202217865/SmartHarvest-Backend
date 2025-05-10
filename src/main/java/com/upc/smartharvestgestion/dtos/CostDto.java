package com.upc.smartharvestgestion.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.upc.smartharvestgestion.entitites.Cost}
 */
@Getter
@Setter
@Value
public class CostDto implements Serializable {
    Long id;
    String concept;
    Double amount;
    CropDto crop;
}