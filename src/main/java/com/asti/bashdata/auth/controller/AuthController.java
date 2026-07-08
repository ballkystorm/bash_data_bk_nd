package com.asti.bashdata.auth.controller;

import com.asti.bashdata.auth.dto.request.LoginRequest;
import com.asti.bashdata.auth.dto.response.LoginResponse;
import com.asti.bashdata.auth.service.AuthService;
import com.asti.bashdata.auth.service.CurrentUserService;
import com.asti.bashdata.common.api.ApiResponse;
import com.asti.bashdata.common.codes.BusinessSuccess;
import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;
import com.asti.bashdata.user.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    private final CurrentUserService currentUserService;

    private final UserMapper userMapper;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(
            @Valid @RequestBody RegisterUserRequest request) {

        UserResponse response =
                authService.register(request);

        return ResponseEntity
                .status(BusinessSuccess.USER_REGISTERED.getStatus())
                .body(
                        ApiResponse.success(
                                BusinessSuccess.USER_REGISTERED,
                                response
                        )
                );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequest request) {

        LoginResponse response =
                authService.login(request);

        return ResponseEntity.ok(
                ApiResponse.success(
                        BusinessSuccess.LOGIN_SUCCESSFUL,
                        response
                )
        );
    }


    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserResponse>> me() {

        UserResponse response = userMapper.toResponse(
                currentUserService.getCurrentUser()
        );

        return ResponseEntity.ok(
                ApiResponse.success(
                        BusinessSuccess.USER_RETRIEVED,
                        response
                )
        );

    }

}