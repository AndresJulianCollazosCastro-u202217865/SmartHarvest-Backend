package com.upc.smartharvestgestion.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.upc.smartharvestgestion.entitites.User}
 */
@Value
public class UserDto implements Serializable {
    Long id;
    String userName;
    String userEmail;
    String userPassword;
    String userLocation;
}