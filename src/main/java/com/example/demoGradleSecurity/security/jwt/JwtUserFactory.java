package com.example.demoGradleSecurity.security.jwt;

import com.example.demoGradleSecurity.entity.RoleEntity;
import com.example.demoGradleSecurity.entity.Status;
import com.example.demoGradleSecurity.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {

    }

    public static JwtUser create(UserEntity user) {
        JwtUser jwtUser = new JwtUser(user.getId(), user.getName(), user.getPassword(), user.getStatus().equals(Status.ACTIVE),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())));
        return jwtUser;
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<RoleEntity> userRoles) {
        return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
