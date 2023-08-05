package com.example.demoGradleSecurity.security;

import com.example.demoGradleSecurity.entity.UserEntity;
import com.example.demoGradleSecurity.repositories.UserRepository;
import com.example.demoGradleSecurity.security.jwt.JwtUser;
import com.example.demoGradleSecurity.security.jwt.JwtUserFactory;
import com.example.demoGradleSecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {

//    private final UserRepository userRepository;

    private final UserService userService;

//    @Autowired
//    public JwtUserDetailService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    @Autowired
    public JwtUserDetailService(UserService userService) {
        this.userService = userService;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findByName(username);
//
//        if(user==null) {
//            throw new UsernameNotFoundException("User not found "+username+" MY EX");
//        }
//
//        JwtUser jwtUser = JwtUserFactory.create(user);
//
//        return jwtUser;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByName(username);

        if(user==null) {
            throw new UsernameNotFoundException("User not found "+username+" MY EX");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);

        return jwtUser;
    }
}
