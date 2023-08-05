package com.example.demoGradleSecurity.repositories;

import com.example.demoGradleSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByEmail(String email);

    UserEntity findByName(String name);
}
