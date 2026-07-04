package com.asti.bashdata.common.validation.pattern;

/**
 * Contains reusable regular expression patterns for validation.
 */
public final class ValidationPatterns {

    private ValidationPatterns() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated."
        );
    }

    /**
     * Password policy:
     * - 8 to 100 characters
     * - One uppercase letter
     * - One lowercase letter
     * - One digit
     * - One special character
     */
    public static final String PASSWORD =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,100}$";

    /**
     * Nigerian mobile number.
     */
    public static final String NIGERIAN_PHONE =
            "^(070|080|081|090|091)\\d{8}$";

}