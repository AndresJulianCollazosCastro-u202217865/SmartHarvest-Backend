package com.upc.sh_joseph.repositories;

import com.example.smartharvest.dtos.AlertReportDto;
import com.example.smartharvest.entities.WeatherAlertEstate;
import com.example.smartharvest.entities.WeatherAlertType;
import com.example.smartharvest.entities.Weatheralert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherAlertRepository extends JpaRepository<Weatheralert, Long> {
    //US24: Marcar alerta como leída
    @Modifying
    @Query("UPDATE Weatheralert w SET w.estado = :estado WHERE w.id = :alertId AND w.userid.id = :userId")
    void updateAlertEstado(@Param("alertId") Long alertId, @Param("userId") Long userId, @Param("estado") WeatherAlertEstate estado);

    //
    // US21: Consulta de Alertas por Ubicación, Tipo y Estado (opcional)
    @Query("""
    SELECT w FROM Weatheralert w
    WHERE w.userid.userLocation = :location
    AND w.userid.id = :userId
    AND w.visible = true
    AND (:type IS NULL OR w.waType = :type)
    AND (:status IS NULL OR w.estado = :status)
    ORDER BY w.waDate DESC
""")
    List<Weatheralert> findVisibleAlertsByLocationAndOptionalTypeAndStatus(
            @Param("location") String location,
            @Param("type") WeatherAlertType type,
            @Param("status") WeatherAlertEstate status,
            @Param("userId") Long userId);
    //

    //US13: Consulta de Alertas Recientes desde una Fecha Específica
    @Query("SELECT w FROM Weatheralert w WHERE w.userid.id = :userId AND w.waDate >= :fromDateTime AND w.visible = true ORDER BY w.waDate DESC")
    List<Weatheralert> findRecentVisibleAlertsByUser(@Param("userId") Long userId,
                                                     @Param("fromDateTime") LocalDateTime fromDateTime);

    // Reporte de número de alertas por tipo de advertencia en una ciudad
    @Query("SELECT new com.example.smartharvest.dtos.AlertReportDto(w.waType, COUNT(w)) FROM Weatheralert w WHERE w.userid.userLocation = :location AND w.userid.id = :userId GROUP BY w.waType")
    List<AlertReportDto> countAlertsByTypeInLocationAndUser(@Param("location") String location,
                                                            @Param("userId") Long userId);

    // US24: Eliminación Lógica de Alertas
    @Modifying
    @Query("UPDATE Weatheralert w SET w.visible = false WHERE w.id = :alertId AND w.userid.id = :userId")
    void logicallyDeleteAlert(@Param("alertId") Long alertId, @Param("userId") Long userId);

}
