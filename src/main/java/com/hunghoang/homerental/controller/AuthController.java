package com.hunghoang.homerental.controller;

import com.hunghoang.homerental.dto.LoginRequest;
import com.hunghoang.homerental.dto.LoginResponse;
import com.hunghoang.homerental.dto.SignupRequest;
import com.hunghoang.homerental.dto.SignupResponse;
import com.hunghoang.homerental.services.security.AuthService;
import com.hunghoang.homerental.util.logging.Level;
import com.hunghoang.homerental.util.logging.Loggable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    final AuthService authService;
    @PostMapping("/login")
    @Loggable(level = Level.INFO)
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        log.info("login: {}", request);
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/signup")
    @Loggable(level = Level.INFO)
    public ResponseEntity<SignupResponse> signup(@RequestBody @Valid SignupRequest dto) {
        log.info("signup: {}", dto);
        return ResponseEntity.ok(authService.signup(dto));
    }
}
