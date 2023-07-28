package com.example.demoGradleSecurity.services;

import com.example.demoGradleSecurity.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User saveUser(User user);

    User findById(int id);

    User findByEmail(String email);

    User updateUser(User user);

    void deleteUserById(int id);
}
