package com.upc.smartharvestrecomendations.Services;

import com.upc.smartharvestrecomendations.Dtos.UserDto;
import com.upc.smartharvestrecomendations.Entities.User;
import com.upc.smartharvestrecomendations.Interfaces.IUserService;
import com.upc.smartharvestrecomendations.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto addUser(UserDto user) {
        User newUser = modelMapper.map(user, User.class);
        newUser = userRepository.save(newUser);
        return modelMapper.map(newUser, UserDto.class);
    }

    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findUserByUserId(userDto.getId());
        modelMapper.map(userDto, user);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    public Integer insertUserRol(Long userId, Long roleId) {
        Integer result = 0;
        userRepository.addUserRole(userId,roleId);
        return 1;
    }
}
