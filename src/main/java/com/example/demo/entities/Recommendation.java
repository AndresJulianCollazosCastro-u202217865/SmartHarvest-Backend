package com.example.demo.entities;

import com.example.demo.security.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "crop_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "recommendations"})
    private Crop crop;

    @Column(name = "rTitle", length = Integer.MAX_VALUE)
    private String rTitle;

    @Column(name = "rDescription", length = Integer.MAX_VALUE)
    private String rDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "rCategory")
    private RecommendationCategory rCategory;

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
    
    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
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
