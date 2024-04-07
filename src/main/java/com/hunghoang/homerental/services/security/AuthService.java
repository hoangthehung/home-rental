package com.hunghoang.homerental.services.security;

import com.hunghoang.homerental.dto.LoginRequest;
import com.hunghoang.homerental.dto.LoginResponse;
import com.hunghoang.homerental.dto.SignupRequest;
import com.hunghoang.homerental.dto.SignupResponse;
import com.hunghoang.homerental.entities.UsersEntity;
import com.hunghoang.homerental.exception.ErrorCode;
import com.hunghoang.homerental.exception.RentalException;
import com.hunghoang.homerental.mapper.InternalMapper;
import com.hunghoang.homerental.model.User;
import com.hunghoang.homerental.model.UserStatus;
import com.hunghoang.homerental.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;
    final AuthenticationManager authenticationManager;
    final InternalMapper internalMapper;
    final JwtService jwtService;

    public SignupResponse signup(SignupRequest userDto) {
        try {
            var user = internalMapper.toUsersEntity(userDto);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setStatus(UserStatus.ACTIVATED);
            return internalMapper.toSignupResponse(userRepository.saveAndFlush(user));
        } catch (Exception ex) {
            throw new RentalException(ErrorCode.SIGNUP_FAILED);
        }
    }

    private UsersEntity authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        return userRepository.findByUsername(request.getUsername()).orElseThrow();
    }
    public LoginResponse login(LoginRequest request) {
        UsersEntity authenticatedUser = authenticate(request);
        String jwtToken = jwtService.generateToken(internalMapper.toUser(authenticatedUser));
        return new LoginResponse(jwtToken,jwtService.getExpirationTime());
    }
}
