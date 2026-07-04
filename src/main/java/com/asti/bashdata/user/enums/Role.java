package com.asti.bashdata.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Defines the roles available within the application.
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    USER("User"),

    AGENT("Agent"),

    ADMIN("Administrator"),

    SUPER_ADMIN("Super Administrator");

    private final String displayName;

}