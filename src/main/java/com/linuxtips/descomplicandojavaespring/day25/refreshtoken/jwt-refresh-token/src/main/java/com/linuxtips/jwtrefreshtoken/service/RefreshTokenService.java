package com.linuxtips.jwtrefreshtoken.service;

import com.linuxtips.jwtrefreshtoken.model.RefreshToken;
import com.linuxtips.jwtrefreshtoken.repository.RefreshTokenRepository;
import com.linuxtips.jwtrefreshtoken.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class RefreshTokenService {

    private String SECRET_KEY = "linuxtips";




    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(Long userId) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(userRepository.findById(userId).get());
        refreshToken.setExpirationTime((new Date(System.currentTimeMillis() + 1000 * 60* 2)));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }


    public String generateTokenFromUsername(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60*2)).signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpirationTime().compareTo(Date.from(Instant.now())) < 0) {
            refreshTokenRepository.delete(token);
            log.error("refresh token expirado em [{}], efetue login novamente", token.getExpirationTime());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        return token;
    }

    @Transactional
    public int deleteByUserId(Long userId) {
        return refreshTokenRepository.deleteTokenByUser(userRepository.findById(userId).get());
    }
}
