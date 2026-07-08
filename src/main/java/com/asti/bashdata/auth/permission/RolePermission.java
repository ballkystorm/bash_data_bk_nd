package com.asti.bashdata.auth.permission;

import com.asti.bashdata.user.enums.Role;

import java.util.EnumSet;
import java.util.Set;

/**
 * Maps application roles to their assigned permissions.
 *
 * <p>
 * This class centralizes authorization rules so that
 * permission changes can be made in a single location.
 * </p>
 */
public final class RolePermission {

    /**
     * Utility class.
     */
    private RolePermission() {
    }

    /**
     * Returns all permissions assigned to the specified role.
     *
     * @param role application role
     * @return assigned permissions
     */
    public static Set<Permission> getPermissions(Role role) {

        return switch (role) {

            /*
             * ------------------------------------------------------------
             * Regular Customer
             * ------------------------------------------------------------
             */
            case USER -> EnumSet.of(

                    Permission.WALLET_READ,
                    Permission.WALLET_FUND,

                    Permission.TRANSACTION_READ,

                    Permission.PRODUCT_READ

            );

            /*
             * ------------------------------------------------------------
             * Agent / Reseller
             * ------------------------------------------------------------
             */
            case AGENT -> EnumSet.of(

                    Permission.WALLET_READ,
                    Permission.WALLET_FUND,

                    Permission.TRANSACTION_READ,
                    Permission.PRODUCT_READ,

                    Permission.AGENT_READ

            );

            /*
             * ------------------------------------------------------------
             * Administrator
             * ------------------------------------------------------------
             */
            case ADMIN -> EnumSet.of(

                    Permission.USER_READ,
                    Permission.USER_CREATE,
                    Permission.USER_UPDATE,

                    Permission.AGENT_READ,
                    Permission.AGENT_CREATE,
                    Permission.AGENT_UPDATE,

                    Permission.PRODUCT_READ,
                    Permission.PRODUCT_CREATE,
                    Permission.PRODUCT_UPDATE,

                    Permission.TRANSACTION_READ,
                    Permission.TRANSACTION_EXPORT,

                    Permission.WALLET_READ

            );

            /*
             * ------------------------------------------------------------
             * Super Administrator
             * ------------------------------------------------------------
             */
            case SUPER_ADMIN -> EnumSet.allOf(Permission.class);

        };

    }

}