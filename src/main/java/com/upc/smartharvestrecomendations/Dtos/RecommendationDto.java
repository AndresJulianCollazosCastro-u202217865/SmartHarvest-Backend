package com.upc.smartharvestrecomendations.Dtos;

import com.upc.smartharvestrecomendations.Entities.User;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.upc.smartharvestrecomendations.Entities.Recommendation}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationDto implements Serializable {
    Long recommendationId;
    User user;
    String rTitle;
    String rDescription;
    Object rCategory;
}