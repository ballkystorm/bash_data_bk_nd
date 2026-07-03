package com.asti.bashdata.common.exception;

/**
 * Thrown when a client request violates
 * business validation rules.
 */
public class BadRequestException extends BusinessException {

    public BadRequestException(String message) {
        super(message);
    }

}