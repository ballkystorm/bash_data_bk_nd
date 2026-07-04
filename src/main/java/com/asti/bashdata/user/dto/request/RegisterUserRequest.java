package com.asti.bashdata.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Represents the payload required to register a new user.
 */
public record RegisterUserRequest(

        @NotBlank(message = "First name is required.")
        @Size(max = 50, message = "First name must not exceed 50 characters.")
        String firstName,

        @NotBlank(message = "Last name is required.")
        @Size(max = 50, message = "Last name must not exceed 50 characters.")
        String lastName,

        @NotBlank(message = "Email address is required.")
        @Email(message = "Please provide a valid email address.")
        String email,

        @NotBlank(message = "Phone number is required.")
        @Pattern(
                regexp = "^\\+?[1-9]\\d{7,14}$",
                message = "Phone number must be in international format."
        )
        String phoneNumber,

        @NotBlank(message = "Password is required.")
        @Size(min = 8, max = 100,
                message = "Password must be between 8 and 100 characters.")
        String password,

        @NotBlank(message = "Confirm password is required.")
        String confirmPassword

) {
}