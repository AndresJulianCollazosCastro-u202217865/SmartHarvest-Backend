package com.example.demo.entities;

import com.example.demo.security.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "learningresources")
public class Learningresource {
    @Id
    @Column(name = "lr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public String getLrTitle() {
        return lrTitle;
    }

    public void setLrTitle(String lrTitle) {
        this.lrTitle = lrTitle;
    }

    public String getLrDescription() {
        return lrDescription;
    }

    public void setLrDescription(String lrDescription) {
        this.lrDescription = lrDescription;
    }

    public String getLrCategory() {
        return lrCategory;
    }

    public void setLrCategory(String lrCategory) {
        this.lrCategory = lrCategory;
    }

    public String getLrLink() {
        return lrLink;
    }

    public void setLrLink(String lrLink) {
        this.lrLink = lrLink;
    }
}