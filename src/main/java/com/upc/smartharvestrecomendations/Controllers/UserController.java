package com.upc.smartharvestrecomendations.Controllers;

import com.upc.smartharvestrecomendations.Dtos.UserDto;
import com.upc.smartharvestrecomendations.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }

    @PutMapping("/user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(userDto));
    }


    @PostMapping("/assign-role/{user_id}/{rol_id}")
    public ResponseEntity<Integer> insertUserRol(@RequestBody UserDto userDto, @PathVariable Long user_id,@PathVariable Long rol_id) {
        return ResponseEntity.ok(userService.insertUserRol(user_id,rol_id));
    }

}
