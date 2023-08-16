package com.linuxtips.jwtrefreshtoken.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginRequest implements Serializable {
    private String username;
    private String password;


}
