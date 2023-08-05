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
//        System.out.println("JWTUser");
//        System.out.println(user.getRoles().get(0));
//        System.out.println(user.getId());
//        System.out.println(user.getName());
//        System.out.println(user.getPassword());
//        System.out.println(user.getStatus());

//        return new JwtUser(user.getId(), user.getName(),
//                user.getPassword(), user.getStatus().equals("ACTIVE"),
//                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())));

        JwtUser jwtUser = new JwtUser(user.getId(), user.getName(), user.getPassword(), user.getStatus().equals(Status.ACTIVE),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())));
//        System.out.println(jwtUser.getId());
//        System.out.println(jwtUser.getName());
//        System.out.println(jwtUser.getPassword());
//        System.out.println(jwtUser.isEnabled());

        return jwtUser;
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<RoleEntity> userRoles) {
        return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
