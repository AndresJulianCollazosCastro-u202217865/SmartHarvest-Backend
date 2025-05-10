package com.example.demo.dtos;

import com.example.demo.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LearningResourceDto implements Serializable {
    Long id;
    String lrTitle;
    String lrDescription;
    String lrCategory;
    String lrLink;
    UserDto userid;
}
