package com.example.demoGradleSecurity.dto;

import com.example.demoGradleSecurity.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private int id;
    private String username;
    private String email;

    public UserEntity toUser(){
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(username);
        user.setEmail(email);
        return user;
    }

    public static AdminUserDto fromUser(UserEntity user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getName());
        adminUserDto.setEmail(user.getEmail());
        return adminUserDto;
    }
}
