package com.asti.bashdata.common.constants.validation;

/**
 * Centralized validation messages used throughout the application.
 */
public final class ValidationMessages {

    private ValidationMessages() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated."
        );
    }

    /*
     * First Name
     */
    public static final String FIRST_NAME_REQUIRED =
            "First name is required.";

    public static final String FIRST_NAME_MAX_LENGTH =
            "First name exceeds the maximum allowed length.";

    /*
     * Last Name
     */
    public static final String LAST_NAME_REQUIRED =
            "Last name is required.";

    public static final String LAST_NAME_MAX_LENGTH =
            "Last name must not exceed 50 characters.";

    /*
     * Email
     */
    public static final String EMAIL_REQUIRED =
            "Email address is required.";

    public static final String INVALID_EMAIL =
            "Please provide a valid email address.";

    /*
     * Phone Number
     */
    public static final String PHONE_REQUIRED =
            "Phone number is required.";

    public static final String INVALID_PHONE =
            "Please provide a valid Nigerian phone number.";

    /*
     * Password
     */
    public static final String PASSWORD_REQUIRED =
            "Password is required.";

    public static final String CONFIRM_PASSWORD_REQUIRED =
            "Confirm password is required.";

    public static final String INVALID_PASSWORD =
            "Password does not meet the required security policy.";

    public static final String PASSWORD_MISMATCH =
            "Password and confirm password do not match.";

}