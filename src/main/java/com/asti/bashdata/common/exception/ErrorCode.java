package com.asti.bashdata.common.exception;

/**
 * Represents all business error codes exposed by the API.
 *
 * Error codes provide a stable contract between the backend
 * and API consumers regardless of message wording.
 */
public enum ErrorCode {

    // User

    USER_NOT_FOUND("USR_001"),

    EMAIL_ALREADY_EXISTS("USR_002"),

    PHONE_ALREADY_EXISTS("USR_003"),

    USER_ALREADY_VERIFIED("USR_004"),

    // Authentication

    INVALID_CREDENTIALS("AUTH_001"),

    TOKEN_EXPIRED("AUTH_002"),

    INVALID_TOKEN("AUTH_003"),

    ACCESS_DENIED("AUTH_004"),

    // Wallet

    WALLET_NOT_FOUND("WAL_001"),

    INSUFFICIENT_BALANCE("WAL_002"),

    // Transaction

    TRANSACTION_NOT_FOUND("TXN_001"),

    DUPLICATE_TRANSACTION("TXN_002"),

    // Generic

    VALIDATION_ERROR("GEN_001"),

    INTERNAL_SERVER_ERROR("GEN_999");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}