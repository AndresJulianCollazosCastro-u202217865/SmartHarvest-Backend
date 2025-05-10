package com.upc.smartharvestrecomendations.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
