package com.linuxtips.jwtrefreshtoken.controller;


import com.linuxtips.jwtrefreshtoken.jwt.Util;
import com.linuxtips.jwtrefreshtoken.model.RefreshToken;
import com.linuxtips.jwtrefreshtoken.model.User;
import com.linuxtips.jwtrefreshtoken.request.LoginRequest;
import com.linuxtips.jwtrefreshtoken.request.RefreshTokenRequest;
import com.linuxtips.jwtrefreshtoken.response.RefreshTokenResponse;
import com.linuxtips.jwtrefreshtoken.service.LoginService;
import com.linuxtips.jwtrefreshtoken.service.RefreshTokenService;
import com.linuxtips.jwtrefreshtoken.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @Autowired
    RefreshTokenService refreshTokenService;

    @Autowired
    private Util util;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        log.info("criando um novo usuário com as infos : [{}]", user);
        return this.userService.createNewUser(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
        log.info("usuário [{}] fazendo login", loginRequest.getUsername());
   return loginService.login(loginRequest);
    }


    @PostMapping("/refreshtoken")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> refreshtoken( @RequestBody RefreshTokenRequest request) {

        log.info("Solicitação de criação de refresh token para o token [{}]", request);
        return refreshTokenService.findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = refreshTokenService.generateTokenFromUsername(user.getUsername());
                   log.info("refresh token gerado com sucesso [{}]", token);
                    return ResponseEntity.ok(new RefreshTokenResponse(token, request.getRefreshToken(), "Bearer"));
                })
                .orElseThrow(() -> new CredentialsExpiredException(request.getRefreshToken()));
    }


    }
