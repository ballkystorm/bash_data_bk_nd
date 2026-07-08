package com.asti.bashdata.user.service;

import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;
import com.asti.bashdata.user.entity.User;

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


    /**
     * Finds a user by email.
     *
     * @param email user email
     * @return user entity
     */
    User findByEmail(String email);


}