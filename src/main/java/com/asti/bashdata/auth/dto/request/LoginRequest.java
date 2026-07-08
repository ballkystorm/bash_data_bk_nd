package com.asti.bashdata.auth.dto.request;

import com.asti.bashdata.common.constants.validation.ValidationMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents a user login request.
 */
public record LoginRequest(

        @NotBlank(message = ValidationMessages.EMAIL_REQUIRED)
        @Email(message = ValidationMessages.INVALID_EMAIL)
        String email,

        @NotBlank(message = ValidationMessages.PASSWORD_REQUIRED)
        String password

) {
}