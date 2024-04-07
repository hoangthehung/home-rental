package com.hunghoang.homerental.dto;

import com.hunghoang.homerental.util.MaskingUtil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Data
public class SignupRequest {
    @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String fullName;
    private String phoneNumber;

    @Override
    public String toString() {
        return "SignupRequest{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + MaskingUtil.mask(password) + '\'' +
                ", fullName='" + fullName + '\'' +
                ", fullName='" + phoneNumber + '\'' +
                '}';
    }
}
