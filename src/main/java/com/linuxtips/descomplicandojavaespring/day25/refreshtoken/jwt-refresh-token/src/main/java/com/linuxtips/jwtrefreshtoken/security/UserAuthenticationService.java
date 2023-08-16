package com.linuxtips.jwtrefreshtoken.security;

import com.linuxtips.jwtrefreshtoken.model.User;
import com.linuxtips.jwtrefreshtoken.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User inDB = userRepository.findByUsername(username);
        if (inDB == null) {
            throw new UsernameNotFoundException("Usuário não cadastrado na base de dados");
        }
        return new AppUser(inDB);
    }
}