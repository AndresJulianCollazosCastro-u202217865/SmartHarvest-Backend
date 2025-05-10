package com.upc.smartharvestrecomendations.Dtos;

import com.upc.smartharvestrecomendations.Entities.Role;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.upc.smartharvestrecomendations.Entities.User}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    Long userId;
    String userName;
    String userEmail;
    String userPassword;
    String userLocation;
    Set<Role> roles;
    Object userRole;
    public Long getId() {
        return userId;
    }
}