package com.hunghoang.homerental.dto;

import com.hunghoang.homerental.util.MaskingUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + MaskingUtil.mask(password) + '\'' +
                '}';
    }
}
