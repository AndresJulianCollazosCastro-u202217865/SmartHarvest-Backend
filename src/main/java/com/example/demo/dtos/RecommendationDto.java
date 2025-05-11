package com.example.demo.dtos;

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
    Long recommendationId;
    User user;
    String rTitle;
    String rDescription;
    Object rCategory;

    public Long getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Object getrCategory() {
        return rCategory;
    }

    public void setrCategory(Object rCategory) {
        this.rCategory = rCategory;
    }
}