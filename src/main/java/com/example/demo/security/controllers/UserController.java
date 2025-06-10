package com.example.demo.security.controllers;

import com.example.demo.security.dtos.UserDto;
import com.example.demo.security.interfaces.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SmartHarvest")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private IUserServices userServices;

    @Autowired
    private PasswordEncoder bcrypt;

    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        String bcryptPassword = bcrypt.encode(user.getUserPassword());
        user.setUserPassword(bcryptPassword);
        return new ResponseEntity<>(userServices.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        if (user.getUserPassword() != null && !user.getUserPassword().isEmpty()) {
            String bcryptPassword = bcrypt.encode(user.getUserPassword());
            user.setUserPassword(bcryptPassword);
        }
        return new ResponseEntity<>(userServices.updateUser(user), HttpStatus.OK);
    }


    @PostMapping("/assign-role/{user_id}/{rol_id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Integer> saveUserRole(@PathVariable("user_id") Long user_id, @PathVariable("rol_id") Long rol_id) {
        return new ResponseEntity<Integer>(userServices.insertUserRol(user_id, rol_id), HttpStatus.OK);
    }

}
