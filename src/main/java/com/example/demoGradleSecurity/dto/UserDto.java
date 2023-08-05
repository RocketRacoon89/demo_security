package com.example.demoGradleSecurity.dto;


import com.example.demoGradleSecurity.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
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

    public static UserDto fromUser(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
