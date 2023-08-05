package com.example.demoGradleSecurity.security;

import com.example.demoGradleSecurity.entity.UserEntity;
import com.example.demoGradleSecurity.repositories.UserRepository;
import com.example.demoGradleSecurity.security.jwt.JwtUser;
import com.example.demoGradleSecurity.security.jwt.JwtUserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByName(username);

        if(user==null) {
            throw new UsernameNotFoundException("User not found "+username+" MY EX");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);

        return jwtUser;
    }
}
