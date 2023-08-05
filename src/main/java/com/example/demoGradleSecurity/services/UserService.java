package com.example.demoGradleSecurity.services;

import com.example.demoGradleSecurity.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAll();

    UserEntity saveUser(UserEntity user);

    UserEntity findById(int id);

    UserEntity findByName(String name);

    UserEntity findByEmail(String email);

    UserEntity updateUser(UserEntity user);

    void deleteUserById(int id);
}
