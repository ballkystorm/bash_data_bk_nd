package com.asti.bashdata.common.exception;

/**
 * Thrown when authentication is required
 * or authentication fails.
 */
public class UnauthorizedException extends BusinessException {

    public UnauthorizedException(String message) {
        super(message);
    }

}