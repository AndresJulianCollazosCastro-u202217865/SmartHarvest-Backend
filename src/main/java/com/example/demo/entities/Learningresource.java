package com.example.demo.entities;

import com.example.demo.security.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "learningresources")
public class Learningresource {
    @Id
    @Column(name = "lr_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @Column(name = "lr_title", length = Integer.MAX_VALUE)
    private String lrTitle;

    @Column(name = "lr_description", length = Integer.MAX_VALUE)
    private String lrDescription;

    @Column(name = "lr_category", length = Integer.MAX_VALUE)
    private String lrCategory;

    @Column(name = "lr_link", length = Integer.MAX_VALUE)
    private String lrLink;

}