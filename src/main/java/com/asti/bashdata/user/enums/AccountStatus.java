package com.asti.bashdata.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Defines the possible states of a user account.
 */
@Getter
@RequiredArgsConstructor
public enum AccountStatus {

    ACTIVE("Active"),

    SUSPENDED("Suspended"),

    LOCKED("Locked"),

    DEACTIVATED("Deactivated");

    private final String displayName;

}