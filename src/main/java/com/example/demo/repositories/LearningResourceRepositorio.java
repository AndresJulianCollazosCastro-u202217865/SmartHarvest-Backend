package com.example.demo.repositories;

import com.example.demo.entities.Learningresource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearningResourceRepositorio extends JpaRepository<Learningresource,Long> {
    List<Learningresource> findLearningResourceByLrCategoryContaining(String lrCategory);

}
