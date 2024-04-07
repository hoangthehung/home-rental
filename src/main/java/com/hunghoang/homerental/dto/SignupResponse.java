package com.hunghoang.homerental.dto;

import com.hunghoang.homerental.model.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SignupResponse {
    private String email;
    private String username;
    private String password;
    private String fullName;
    private UserStatus status;
}
