package com.asti.bashdata.auth.service.impl;

import com.asti.bashdata.auth.dto.request.LoginRequest;
import com.asti.bashdata.auth.dto.response.LoginResponse;
import com.asti.bashdata.auth.security.SecurityUser;
import com.asti.bashdata.auth.service.AuthService;
import com.asti.bashdata.auth.service.JwtService;
import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;
import com.asti.bashdata.user.entity.User;
import com.asti.bashdata.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    @Override
    public UserResponse register(RegisterUserRequest request) {

        return userService.registerUser(request);

    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(

                        new UsernamePasswordAuthenticationToken(
                                request.email(),
                                request.password()
                        )

                );

        SecurityUser securityUser =
                (SecurityUser) authentication.getPrincipal();

        User user =
                userService.findByEmail(
                        securityUser.getUsername()
                );

        String accessToken =
                jwtService.generateAccessToken(user);

        return new LoginResponse(

                user.getId(),

                user.getUserCode(),

                user.getFirstName() + " " + user.getLastName(),

                user.getFirstName(),

                user.getLastName(),

                user.getEmail(),

                user.getPhoneNumber(),

                user.getRole(),

                user.getAccountStatus(),

                user.getEmailVerifiedAt() != null,

                user.getPhoneVerifiedAt() != null,

                accessToken,

                "Bearer",

                LocalDateTime.now()

        );

    }

}