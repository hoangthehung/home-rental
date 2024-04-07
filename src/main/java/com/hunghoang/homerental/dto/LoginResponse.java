package com.hunghoang.homerental.dto;

import com.hunghoang.homerental.util.MaskingUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private long expiresIn;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + MaskingUtil.mask(token) + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
