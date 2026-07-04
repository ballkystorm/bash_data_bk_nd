package com.asti.bashdata.common.constants.database;

/**
 * Defines database column constraints used across the application.
 */
public final class DatabaseConstraints {

    private DatabaseConstraints() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated."
        );
    }

    public static final int USER_CODE_LENGTH = 20;

    public static final int NAME_LENGTH = 50;

    public static final int EMAIL_LENGTH = 100;

    public static final int PHONE_NUMBER_LENGTH = 20;

    public static final int PASSWORD_HASH_LENGTH = 255;

}