package com.example.demoGradleSecurity.services.impl;

import com.example.demoGradleSecurity.entity.UserEntity;
import com.example.demoGradleSecurity.repositories.UserRepository;
import com.example.demoGradleSecurity.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    
    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity findByName(String name) {return userRepository.findByName(name);}

//    @Override
//    public UserEntity findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }

    @Override
    @Transactional
    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
