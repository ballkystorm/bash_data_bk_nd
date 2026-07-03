package com.asti.bashdata.common.exception;

/**
 * Thrown when the authenticated user
 * is not permitted to perform an action.
 */
public class ForbiddenException extends BusinessException {

    public ForbiddenException(String message) {
        super(message);
    }

}