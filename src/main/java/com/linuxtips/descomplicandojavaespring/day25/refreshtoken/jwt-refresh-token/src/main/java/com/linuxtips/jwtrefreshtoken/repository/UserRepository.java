package com.linuxtips.jwtrefreshtoken.repository;

import com.linuxtips.jwtrefreshtoken.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


}