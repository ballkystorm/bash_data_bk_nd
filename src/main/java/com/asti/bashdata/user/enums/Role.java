package com.asti.bashdata.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Defines all application roles.
 *
 * <ul>
 *     <li>USER - Regular customer.</li>
 *     <li>AGENT - Business reseller.</li>
 *     <li>ADMIN - Operations administrator.</li>
 *     <li>SUPER_ADMIN - Full system administrator.</li>
 * </ul>
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    /**
     * Regular application user.
     */
    USER("User"),

    /**
     * Agent or reseller.
     */
    AGENT("Agent"),

    /**
     * Operations administrator.
     */
    ADMIN("Administrator"),

    /**
     * System owner with unrestricted access.
     */
    SUPER_ADMIN("Super Administrator");

    private final String displayName;

}