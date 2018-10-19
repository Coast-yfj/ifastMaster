package com.ifast.api.pojo.dto;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 * <small> 2018/8/28 11:04 | Aron</small>
 */
@Data
public class UserLogoutDTO {
    private String token;
    private String refreshToken;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
