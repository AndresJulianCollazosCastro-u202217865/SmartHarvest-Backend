package com.example.demo.entities;

import com.example.demo.security.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recommendations")
public class Recommendation {
    @Id
    @Column(name = "recomendationId", nullable = false)
    private Long recommendationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "rTitle", length = Integer.MAX_VALUE)
    private String rTitle;

    @Column(name = "rDescription", length = Integer.MAX_VALUE)
    private String rDescription;

    @Column(name = "rCategory", columnDefinition = "recomendation_category_enum")
    private Object rCategory;

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
