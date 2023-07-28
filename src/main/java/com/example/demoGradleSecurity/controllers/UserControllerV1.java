package com.example.demoGradleSecurity.controllers;

import com.example.demoGradleSecurity.entity.User;
import com.example.demoGradleSecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("test_security/v1/users")
public class UserControllerV1 {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/id")
    public User getUser(@PathVariable int id) {
        return userService.findById(id);
    }

    @GetMapping("/email")
    public User getUser(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/id")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }




}
