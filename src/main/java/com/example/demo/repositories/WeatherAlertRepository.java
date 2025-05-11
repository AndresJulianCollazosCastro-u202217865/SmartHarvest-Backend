package com.example.demo.repositories;


import com.example.demo.dtos.AlertReportDto;
import com.example.demo.entities.WeatherAlertEstate;
import com.example.demo.entities.WeatherAlertType;
import com.example.demo.entities.Weatheralert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherAlertRepository extends JpaRepository<Weatheralert, Long> {
    //US19: Marcar alerta como leída
    @Modifying
    @Query("UPDATE Weatheralert w SET w.estado = :estado WHERE w.id = :alertId AND w.userid = :userId")
    void updateAlertEstado(@Param("alertId") Long alertId, @Param("userId") Long userId, @Param("estado") WeatherAlertEstate estado);

    //
    // US15: Consulta de Alertas por Tipo y Estado
    @Query("""
    SELECT w FROM Weatheralert w
    WHERE w.userid = :userId
    AND w.visible = true
    AND (:type IS NULL OR w.waType = :type)
    AND (:status IS NULL OR w.estado = :status)
    ORDER BY w.waDate DESC
""")
    List<Weatheralert> findVisibleAlertsByOptionalTypeAndStatus(
            @Param("type") WeatherAlertType type,
            @Param("status") WeatherAlertEstate status,
            @Param("userId") Long userId);
    //

    //US16: Consulta de Alertas Recientes desde una Fecha Específica
    @Query("SELECT w FROM Weatheralert w WHERE w.userid = :userId AND w.waDate >= :fromDateTime AND w.visible = true ORDER BY w.waDate DESC")
    List<Weatheralert> findRecentVisibleAlertsByUser(@Param("userId") Long userId,
                                                     @Param("fromDateTime") LocalDateTime fromDateTime);

    //US18: Generación de Reporte de Alertas por Tipo de Alerta
    @Query("SELECT new com.example.demo.dtos.AlertReportDto(w.waType, COUNT(w)) FROM Weatheralert w WHERE w.userid = :userId GROUP BY w.waType")
    List<AlertReportDto> countAlertsByTypeAndUser(@Param("userId") Long userId);

    // US17: Eliminación Lógica de Alertas
    @Modifying
    @Query("UPDATE Weatheralert w SET w.visible = false WHERE w.id = :alertId AND w.userid = :userId")
    void logicallyDeleteAlert(@Param("alertId") Long alertId, @Param("userId") Long userId);

}
