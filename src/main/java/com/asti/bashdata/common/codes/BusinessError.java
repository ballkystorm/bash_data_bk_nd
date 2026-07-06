package com.asti.bashdata.common.codes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Defines all business errors used throughout the application.
 */
@Getter
@RequiredArgsConstructor
public enum BusinessError {

    /*
     * ------------------------------------------------------------------------
     * User Errors
     * ------------------------------------------------------------------------
     */

    EMAIL_ALREADY_EXISTS(
            "USR_E001",
            "Email address already exists.",
            HttpStatus.CONFLICT
    ),

    PHONE_NUMBER_ALREADY_EXISTS(
            "USR_E002",
            "Phone number already exists.",
            HttpStatus.CONFLICT
    ),

    INVALID_PHONE_NUMBER(
            "USR_E009",
            "Invalid Nigerian phone number.",
            HttpStatus.BAD_REQUEST
    ),

    USER_NOT_FOUND(
            "USR_E003",
            "User not found.",
            HttpStatus.NOT_FOUND
    ),

    PASSWORD_MISMATCH(
            "USR_E004",
            "Password and confirm password do not match.",
            HttpStatus.BAD_REQUEST
    ),

    INVALID_CREDENTIALS(
            "USR_E005",
            "Invalid email or password.",
            HttpStatus.UNAUTHORIZED
    ),

    ACCOUNT_LOCKED(
            "USR_E006",
            "Your account has been locked.",
            HttpStatus.FORBIDDEN
    ),

    ACCOUNT_SUSPENDED(
            "USR_E007",
            "Your account has been suspended.",
            HttpStatus.FORBIDDEN
    ),

    ACCOUNT_DEACTIVATED(
            "USR_E008",
            "Your account has been deactivated.",
            HttpStatus.FORBIDDEN
    ),

    /*
     * ------------------------------------------------------------------------
     * System Errors
     * ------------------------------------------------------------------------
     */

    VALIDATION_FAILED(
            "SYS_E001",
            "Validation failed.",
            HttpStatus.BAD_REQUEST
    ),

    INTERNAL_SERVER_ERROR(
            "SYS_E999",
            "An unexpected error occurred.",
            HttpStatus.INTERNAL_SERVER_ERROR
    );

    private final String code;

    private final String message;

    private final HttpStatus status;

}