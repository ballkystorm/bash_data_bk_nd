package com.asti.bashdata.common.codes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Defines all successful business operations returned by the application.
 *
 * Each success contains:
 * - Business code
 * - Success message
 * - Appropriate HTTP status
 */
@Getter
@RequiredArgsConstructor
public enum BusinessSuccess {

    /*
     * ------------------------------------------------------------------------
     * User Success
     * ------------------------------------------------------------------------
     */

    USER_REGISTERED(
            "USR_S001",
            "User registered successfully.",
            HttpStatus.CREATED
    ),

    USER_RETRIEVED(
            "USR_S002",
            "User retrieved successfully.",
            HttpStatus.OK
    ),

    USER_UPDATED(
            "USR_S003",
            "User updated successfully.",
            HttpStatus.OK
    ),

    PASSWORD_CHANGED(
            "USR_S004",
            "Password changed successfully.",
            HttpStatus.OK
    ),

    LOGIN_SUCCESSFUL(
            "USR_S005",
            "Login successful.",
            HttpStatus.OK
    );

    private final String code;

    private final String message;

    private final HttpStatus status;

}