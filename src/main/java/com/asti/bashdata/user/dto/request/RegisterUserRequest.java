package com.asti.bashdata.user.dto.request;

import com.asti.bashdata.common.constants.validation.ValidationLimits;
import com.asti.bashdata.common.constants.validation.ValidationMessages;
import com.asti.bashdata.common.validation.annotation.ValidPassword;
import com.asti.bashdata.common.validation.annotation.ValidPhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents the request payload for user registration.
 */
public record RegisterUserRequest(

        @NotBlank(message = ValidationMessages.FIRST_NAME_REQUIRED)
        @Size(
                max = ValidationLimits.FIRST_NAME_MAX_LENGTH,
                message = ValidationMessages.FIRST_NAME_MAX_LENGTH
        )
        String firstName,

        @NotBlank(message = ValidationMessages.LAST_NAME_REQUIRED)
        @Size(
                max = ValidationLimits.LAST_NAME_MAX_LENGTH,
                message = ValidationMessages.LAST_NAME_MAX_LENGTH
        )
        String lastName,

        @NotBlank(message = ValidationMessages.EMAIL_REQUIRED)
        @Email(message = ValidationMessages.INVALID_EMAIL)
        String email,

        @NotBlank(message = ValidationMessages.PHONE_REQUIRED)
        @ValidPhoneNumber
        String phoneNumber,

        @NotBlank(message = ValidationMessages.PASSWORD_REQUIRED)
        @ValidPassword
        String password,

        @NotBlank(message = ValidationMessages.CONFIRM_PASSWORD_REQUIRED)
        String confirmPassword

) {
}