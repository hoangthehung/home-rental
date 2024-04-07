package com.hunghoang.homerental.controller;

import com.hunghoang.homerental.exception.Error;
import com.hunghoang.homerental.exception.ErrorCode;
import com.hunghoang.homerental.exception.RentalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebInputException;

import java.util.Arrays;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<List<Error>> handleServerWebInputException(
            ServerWebInputException exception) {

        String reason = exception.getReason();
        if(reason != null) {
            reason = Arrays.stream(reason.split(":")).findFirst().orElse("");
        }

        List<Error> errorResponse =
                errorResponse(
                        ErrorCode.MISSING_REQUIRED_PARAM.getCode(), reason);
        return new ResponseEntity<>(
                errorResponse, ErrorCode.MISSING_REQUIRED_PARAM.getStatus());
    }

    private List<Error> errorResponse(String code, String message) {
        Error error = new Error();
        error.setCode(code);
        error.setMessage(message);
        return Arrays.asList(error);
    }

    @ExceptionHandler(RentalException.class)
    public ResponseEntity handleKeyCloakException(RentalException exception) {
        HttpStatus httpStatus = exception.getErrorCode().getStatus();
        ResponseEntity responseEntity =
                new ResponseEntity(
                        errorResponse(exception.getErrorCode().getCode(), exception.getErrorCode().getMessage()),
                        httpStatus);
        log.info("IAMException {}", exception.getMessage());
        return responseEntity;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<List<Error>> handleAccessDeniedException(
            AccessDeniedException accessDeniedException) {
        log.error("Handle AccessDeniedException ", accessDeniedException);
        return new ResponseEntity<>(
                errorResponse(
                        ErrorCode.ACCESS_DENIED.getCode(),
                        ErrorCode.ACCESS_DENIED.getMessage()),
                ErrorCode.ACCESS_DENIED.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<List<Error>> handleException(Exception exception) {
        List<Error> errorResponse= errorResponse(ErrorCode.AUTH_GENERIC_EXCEPTION.getCode(), exception.getMessage());
        ResponseEntity<List<Error>> responseEntity = new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        log.info("Internal error HttpStatus: {} Error Message: {}",HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        log.error("ex", exception);
        return responseEntity;
    }


}
