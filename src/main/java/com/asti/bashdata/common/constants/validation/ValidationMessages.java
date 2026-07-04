package com.asti.bashdata.common.constants.validation;

/**
 * Centralized validation messages.
 */
public final class ValidationMessages {

    private ValidationMessages() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated."
        );
    }

    public static final String REQUIRED =
            "This field is required.";

    public static final String INVALID_EMAIL =
            "Please provide a valid email address.";

    public static final String INVALID_PHONE =
            "Please provide a valid Nigerian phone number.";

    public static final String INVALID_PASSWORD =
            "Password does not meet the required security policy.";

    public static final String PASSWORD_MISMATCH =
            "Password and confirm password do not match.";

}