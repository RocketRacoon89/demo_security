package com.example.demoGradleSecurity.rest;

import com.example.demoGradleSecurity.entity.UserEntity;
import com.example.demoGradleSecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserControllerV1 {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable int id) {
        return userService.findById(id);
    }

//    @GetMapping("/email")
//    public UserEntity getUser(@PathVariable String email) {
//        return userService.findByEmail(email);
//    }

    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity user) {
        return userService.saveUser(user);
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }




}
