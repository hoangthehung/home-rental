package com.hunghoang.homerental.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ErrorCode {
    FIELD_IS_REQUIRED(HttpStatus.BAD_REQUEST, 1001, "{field} is required"),
    MISSING_REQUIRED_PARAM(HttpStatus.BAD_REQUEST, 1002, "{field} is required"),
    INVALID_USERNAME_PASSWORD(HttpStatus.UNAUTHORIZED, 1003, "Invalid username or password"),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, 1004, "Access denied"),
    AUTH_GENERIC_EXCEPTION(HttpStatus.UNAUTHORIZED, 1005, "Invalid username or password"),
    SIGNUP_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, 1006, "Create user is failed");
    @Getter
    private final HttpStatus status;
    private final int code;
    @Getter
    private final String message;

    public String getCode() {
        return String.valueOf(code);
    }
    public int getStatusValue() {
        return status.value();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InternalErrorCode{");
        sb.append("status='").append(status.toString()).append('\'');
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
