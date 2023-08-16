package com.linuxtips.jwtrefreshtoken.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginResponse implements Serializable {

    public LoginResponse(String jwtToken, String type, String refreshToken, String username, Long id) {
        this.jwtToken = jwtToken;
        this.type = type;
        this.refreshToken = refreshToken;
        this.username = username;
        this.id = id;
    }

    private final String jwtToken;
    private String type = "Bearer";
    private String refreshToken;
    private String username;
    private Long id;






}
