package com.asti.bashdata.user.constants;

import com.asti.bashdata.user.enums.AccountStatus;
import com.asti.bashdata.user.enums.Role;

/**
 * Default values used within the User module.
 */
public final class UserConstants {

    private UserConstants() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated."
        );
    }

    public static final Role DEFAULT_ROLE = Role.USER;

    public static final AccountStatus DEFAULT_ACCOUNT_STATUS =
            AccountStatus.ACTIVE;

}