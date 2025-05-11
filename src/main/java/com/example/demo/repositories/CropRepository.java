package com.example.demo.repositories;


import com.example.demo.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {
   // Buscar cultivos por usuario
    // List<Crop> findByUserId(Long userId);
//
//    // Buscar cultivos por tipo (cultivo de papa, maiz, arroz)
//    List<Crop> findByCropType(String cropType);
//
//    // Buscar por ubicación
//    List<Crop> findByCropUbicationContainingIgnoreCase(String ubication);
//
//    // Buscar por nombre
//    List<Crop> findByCropNameContainingIgnoreCase(String name);
}