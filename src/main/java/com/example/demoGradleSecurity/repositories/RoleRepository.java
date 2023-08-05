package com.example.demoGradleSecurity.repositories;

import com.example.demoGradleSecurity.entity.RoleEntity;
import com.example.demoGradleSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    UserEntity findByName(String name);
}
