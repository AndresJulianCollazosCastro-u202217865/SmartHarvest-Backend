package com.example.demo.dtos;

import com.example.demo.entities.RecommendationCategory;
import com.example.demo.security.dtos.UserDto;
import com.example.demo.security.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 */

@AllArgsConstructor
@NoArgsConstructor
public class RecommendationDto implements Serializable {
    private Long recommendationId;
    private Long userId;
    private String rTitle;
    private String rDescription;
    private RecommendationCategory rCategory;
    private Long cropId;

    public Long getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCropId() {
		return cropId;
	}

	public void setCropId(Long cropId) {
		this.cropId = cropId;
	}

	public String getrTitle() {
        return rTitle;
    }

    public void setrTitle(String rTitle) {
        this.rTitle = rTitle;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription;
    }

    public RecommendationCategory getrCategory() {
        return rCategory;
    }

    public void setrCategory(RecommendationCategory rCategory) {
        this.rCategory = rCategory;
    }
}