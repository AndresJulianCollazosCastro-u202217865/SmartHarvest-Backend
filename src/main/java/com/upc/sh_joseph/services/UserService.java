package com.upc.sh_joseph.services;


import com.upc.sh_joseph.dtos.UserDto;
import com.upc.sh_joseph.entities.User;
import com.upc.sh_joseph.interfaces.IUserService;
import com.upc.sh_joseph.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User saved = userRepository.save(user);
        return modelMapper.map(saved, UserDto.class);
    }
}
