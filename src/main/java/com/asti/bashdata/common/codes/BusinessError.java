package com.asti.bashdata.common.codes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Defines all business errors returned by the application.
 *
 * Each error contains:
 * - Business code
 * - User-friendly message
 * - Appropriate HTTP status
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
            "USR_001",
            "Email address already exists.",
            HttpStatus.CONFLICT
    ),

    PHONE_NUMBER_ALREADY_EXISTS(
            "USR_002",
            "Phone number already exists.",
            HttpStatus.CONFLICT
    ),

    USER_NOT_FOUND(
            "USR_003",
            "User not found.",
            HttpStatus.NOT_FOUND
    ),

    PASSWORD_MISMATCH(
            "USR_004",
            "Password and confirm password do not match.",
            HttpStatus.BAD_REQUEST
    ),

    INVALID_CREDENTIALS(
            "USR_005",
            "Invalid email or password.",
            HttpStatus.UNAUTHORIZED
    ),

    ACCOUNT_LOCKED(
            "USR_006",
            "Your account has been locked.",
            HttpStatus.FORBIDDEN
    ),

    ACCOUNT_SUSPENDED(
            "USR_007",
            "Your account has been suspended.",
            HttpStatus.FORBIDDEN
    ),

    ACCOUNT_DEACTIVATED(
            "USR_008",
            "Your account has been deactivated.",
            HttpStatus.FORBIDDEN
    );

    private final String code;

    private final String message;

    private final HttpStatus httpStatus;

}