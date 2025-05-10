package com.upc.sh_joseph.interfaces;

import com.upc.sh_joseph.dtos.UserDto;

public interface IUserService {
    UserDto saveUser(UserDto userDto);
}
