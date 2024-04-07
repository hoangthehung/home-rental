package com.hunghoang.homerental.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RentalException extends RuntimeException {
    final ErrorCode errorCode;
    final String message;
    String hubErrorCode;

    public RentalException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public RentalException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public RentalException(ErrorCode errorCode, String message, String hubErrorCode) {
        this.errorCode = errorCode;
        this.message = message;
        this.hubErrorCode = hubErrorCode;
    }

}
