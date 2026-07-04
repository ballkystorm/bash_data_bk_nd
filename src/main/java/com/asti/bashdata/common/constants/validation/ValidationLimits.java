package com.asti.bashdata.common.constants.validation;

/**
 * Defines validation limits used across the application.
 */
public final class ValidationLimits {

    private ValidationLimits() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated."
        );
    }

    public static final int FIRST_NAME_MAX_LENGTH = 50;

    public static final int LAST_NAME_MAX_LENGTH = 50;

    public static final int PASSWORD_MIN_LENGTH = 8;

    public static final int PASSWORD_MAX_LENGTH = 100;

}