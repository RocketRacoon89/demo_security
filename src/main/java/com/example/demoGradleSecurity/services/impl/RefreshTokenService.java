package com.example.demoGradleSecurity.services.impl;


import com.example.demoGradleSecurity.entity.RefreshToken;
import com.example.demoGradleSecurity.repositories.RefreshTokenRepository;
import com.example.demoGradleSecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = RefreshToken.builder()
                .userEntity(userRepository.findByName(username))
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(6000000))
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> finedByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if(token.getExpiryDate().compareTo(Instant.now())<0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + "Refresh token was expired.");
        }
        return token;
    }
}
