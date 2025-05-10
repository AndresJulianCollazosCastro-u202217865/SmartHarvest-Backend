package com.upc.smartharvestrecomendations.Interfaces;

import com.upc.smartharvestrecomendations.Dtos.UserDto;

public interface IUserService {
    UserDto addUser(UserDto user);
    UserDto updateUser(UserDto user);
    Integer insertUserRol(Long userId, Long roleId);
}
