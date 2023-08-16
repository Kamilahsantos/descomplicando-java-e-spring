package com.linuxtips.jwtrefreshtoken.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenResponse {

    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";


    public RefreshTokenResponse(String accessToken, String refreshToken, String tokenType) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
    }
}
