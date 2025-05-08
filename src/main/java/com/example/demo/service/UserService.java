package com.example.demo.service;

import com.example.demo.dtos.UserDto;
import com.example.demo.entities.User;
import com.example.demo.interfaces.IUserService;
import com.example.demo.repositories.UserRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepositorio userRepositorio;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto grabarUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User guardar = userRepositorio.save(user);
        return modelMapper.map(guardar, UserDto.class);
    }
}
