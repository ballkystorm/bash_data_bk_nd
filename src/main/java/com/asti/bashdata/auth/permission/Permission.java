package com.asti.bashdata.auth.permission;

/**
 * Defines all permissions available within the application.
 *
 * <p>
 * Permissions represent business capabilities granted to users
 * through their assigned roles.
 * </p>
 *
 * <p>
 * Roles are collections of permissions.
 * </p>
 */
public enum Permission {

    /*
     * ------------------------------------------------------------------------
     * User Management
     * ------------------------------------------------------------------------
     */

    USER_READ,

    USER_CREATE,

    USER_UPDATE,

    USER_DELETE,

    /*
     * ------------------------------------------------------------------------
     * Wallet
     * ------------------------------------------------------------------------
     */

    WALLET_READ,

    WALLET_FUND,

    WALLET_WITHDRAW,

    /*
     * ------------------------------------------------------------------------
     * Transactions
     * ------------------------------------------------------------------------
     */

    TRANSACTION_READ,

    TRANSACTION_EXPORT,

    /*
     * ------------------------------------------------------------------------
     * Products
     * ------------------------------------------------------------------------
     */

    PRODUCT_READ,

    PRODUCT_CREATE,

    PRODUCT_UPDATE,

    PRODUCT_DELETE,

    /*
     * ------------------------------------------------------------------------
     * Agent Management
     * ------------------------------------------------------------------------
     */

    AGENT_READ,

    AGENT_CREATE,

    AGENT_UPDATE,

    /*
     * ------------------------------------------------------------------------
     * Administration
     * ------------------------------------------------------------------------
     */

    ROLE_MANAGE,

    SYSTEM_SETTINGS

}