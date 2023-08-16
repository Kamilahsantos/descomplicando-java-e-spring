package com.linuxtips.jwtrefreshtoken.repository;


import com.linuxtips.jwtrefreshtoken.model.RefreshToken;
import com.linuxtips.jwtrefreshtoken.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteTokenByUser(User user);
}
