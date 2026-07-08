package com.asti.bashdata.auth.service;

import com.asti.bashdata.auth.dto.request.LoginRequest;
import com.asti.bashdata.auth.dto.response.LoginResponse;
import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;

/**
 * Authentication service.
 */
public interface AuthService {

    /**
     * Registers a new user.
     *
     * @param request registration request
     * @return registered user
     */
    UserResponse register(RegisterUserRequest request);

    /**
     * Authenticates a user.
     *
     * @param request login request
     * @return login response
     */
    LoginResponse login(LoginRequest request);

}