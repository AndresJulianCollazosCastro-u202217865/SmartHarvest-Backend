package com.upc.sh_joseph.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_name", length = Integer.MAX_VALUE)
    private String userName;

    @Column(name = "user_email", length = Integer.MAX_VALUE)
    private String userEmail;

    @Column(name = "user_password", length = Integer.MAX_VALUE)
    private String userPassword;

    @Column(name = "user_location", length = Integer.MAX_VALUE)
    private String userLocation;

/*
 TODO [Reverse Engineering] create field to map the 'user_role' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "user_role", columnDefinition = "user_role_enum")
    private Object userRole;
*/
}