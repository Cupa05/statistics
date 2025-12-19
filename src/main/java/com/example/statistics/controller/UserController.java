package com.example.statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.statistics.dto.UserDto;
import com.example.statistics.entity.User;
import com.example.statistics.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) {
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/id")
    public ResponseEntity<User> getUserById(@RequestParam Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
