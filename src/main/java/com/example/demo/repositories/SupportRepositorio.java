package com.example.demo.repositories;

import com.example.demo.entities.Support;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportRepositorio extends JpaRepository<Support,Long> {
}
