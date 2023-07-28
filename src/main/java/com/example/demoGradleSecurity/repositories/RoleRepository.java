package com.example.demoGradleSecurity.repositories;

import com.example.demoGradleSecurity.entity.Role;
import com.example.demoGradleSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    User findByName(String name);
}
