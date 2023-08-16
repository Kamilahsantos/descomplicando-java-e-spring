package com.linuxtips.jwtrefreshtoken.service;


import com.linuxtips.jwtrefreshtoken.model.User;
import com.linuxtips.jwtrefreshtoken.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {


    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createNewUser(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }
}
