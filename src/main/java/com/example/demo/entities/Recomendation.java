package com.example.demo.entities;

import com.example.demo.security.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recomendations")
public class Recomendation {
    @Id
    @Column(name = "recomendation_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

/*
 TODO [Reverse Engineering] create field to map the 'category' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "category", columnDefinition = "recomendation_category_enum")
    private Object category;
*/
}