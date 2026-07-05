package com.asti.bashdata.common.exception;

import com.asti.bashdata.common.codes.BusinessError;
import lombok.Getter;

/**
 * Base exception for all business-related exceptions.
 */
@Getter
public class BusinessException extends RuntimeException {

    private final BusinessError error;

    /**
     * Creates a new business exception.
     *
     * @param error business error
     */
    public BusinessException(BusinessError error) {
        super(error.getMessage());
        this.error = error;
    }

}