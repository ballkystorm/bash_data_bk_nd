package com.asti.bashdata.common.codes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Defines all successful business responses exposed by the application.
 *
 * Each success code contains:
 * - HTTP status
 * - Stable business code
 * - Default response message
 */
@Getter
@RequiredArgsConstructor
public enum SuccessCode implements BusinessCode {

    /*
     * User
     */
    USER_CREATED(
            HttpStatus.CREATED,
            "USR_000",
            "User registered successfully."
    ),

    USER_UPDATED(
            HttpStatus.OK,
            "USR_001",
            "User updated successfully."
    ),

    USER_DELETED(
            HttpStatus.OK,
            "USR_002",
            "User deleted successfully."
    ),

    USER_FETCHED(
            HttpStatus.OK,
            "USR_003",
            "User retrieved successfully."
    ),

    /*
     * Authentication
     */
    LOGIN_SUCCESS(
            HttpStatus.OK,
            "AUTH_000",
            "Login successful."
    ),

    LOGOUT_SUCCESS(
            HttpStatus.OK,
            "AUTH_001",
            "Logout successful."
    ),

    TOKEN_REFRESHED(
            HttpStatus.OK,
            "AUTH_002",
            "Token refreshed successfully."
    ),

    PASSWORD_CHANGED(
            HttpStatus.OK,
            "AUTH_003",
            "Password changed successfully."
    ),

    EMAIL_VERIFIED(
            HttpStatus.OK,
            "AUTH_004",
            "Email verified successfully."
    ),

    /*
     * Wallet
     */
    WALLET_CREATED(
            HttpStatus.CREATED,
            "WAL_000",
            "Wallet created successfully."
    ),

    WALLET_FETCHED(
            HttpStatus.OK,
            "WAL_001",
            "Wallet retrieved successfully."
    ),

    WALLET_FUNDED(
            HttpStatus.OK,
            "WAL_002",
            "Wallet funded successfully."
    ),

    /*
     * Transaction
     */
    TRANSACTION_COMPLETED(
            HttpStatus.OK,
            "TXN_000",
            "Transaction completed successfully."
    ),

    TRANSACTION_FETCHED(
            HttpStatus.OK,
            "TXN_001",
            "Transaction retrieved successfully."
    ),

    /*
     * Data Purchase
     */
    DATA_PURCHASE_SUCCESS(
            HttpStatus.OK,
            "DAT_000",
            "Data purchase completed successfully."
    );

    private final HttpStatus httpStatus;

    private final String code;

    private final String message;

}