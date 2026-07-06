package com.asti.bashdata.auth.controller;

import com.asti.bashdata.common.api.ApiResponse;
import com.asti.bashdata.common.codes.BusinessSuccess;
import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;
import com.asti.bashdata.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Handles authentication-related endpoints.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;

    /**
     * Registers a new user.
     *
     * @param request registration request
     * @return registered user
     */
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(
            @Valid @RequestBody RegisterUserRequest request) {

        UserResponse response =
                userService.registerUser(request);

        return ResponseEntity
                .status(BusinessSuccess.USER_REGISTERED.getStatus())
                .body(
                        ApiResponse.success(
                                BusinessSuccess.USER_REGISTERED,
                                response
                        )
                );
    }

}