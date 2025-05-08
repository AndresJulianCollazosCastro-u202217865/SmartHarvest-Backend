package com.example.demo.entities;

import com.example.demo.security.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "weatheralerts")
public class Weatheralert {
    @Id
    @Column(name = "wa_alert_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @Column(name = "wa_title", length = Integer.MAX_VALUE)
    private String waTitle;

    @Column(name = "wa_description", length = Integer.MAX_VALUE)
    private String waDescription;

    @Column(name = "wa_date")
    private LocalDate waDate;

/*
 TODO [Reverse Engineering] create field to map the 'wa_type' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "wa_type", columnDefinition = "weather_alert_type_enum")
    private Object waType;
*/
}