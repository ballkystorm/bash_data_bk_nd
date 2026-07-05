package com.asti.bashdata.user.service;

import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;

/**
 * Defines business operations for user management.
 */
public interface UserService {

    /**
     * Registers a new user.
     *
     * @param request registration request
     * @return registered user
     */
    UserResponse registerUser(RegisterUserRequest request);

}