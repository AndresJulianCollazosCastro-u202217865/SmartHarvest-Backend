package com.example.demo.security.interfaces;

import com.example.demo.security.dtos.UserDto;

public interface IUserServices {
    UserDto addUser(UserDto user);
    UserDto updateUser(UserDto user);
    Integer insertUserRol(Long userId, Long roleId);
}
