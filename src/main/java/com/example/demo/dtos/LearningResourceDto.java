package com.example.demo.dtos;

import com.example.demo.security.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
public class LearningResourceDto implements Serializable {
    Long id;
    String lrTitle;
    String lrDescription;
    String lrCategory;
    String lrLink;
    UserDto userid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserDto getUserid() {
        return userid;
    }

    public void setUserid(UserDto userid) {
        this.userid = userid;
    }
}
