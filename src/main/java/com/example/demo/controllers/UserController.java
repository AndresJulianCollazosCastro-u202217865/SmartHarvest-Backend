package com.example.demo.controllers;

import com.example.demo.dtos.UserDto;
import com.example.demo.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDto> grabar(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.grabarUser(userDto));
    }
}
