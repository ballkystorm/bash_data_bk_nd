package com.asti.bashdata.common.exception;

import com.asti.bashdata.common.codes.BusinessCode;
import lombok.Getter;

/**
 * Base exception for all business-related errors.
 *
 * Every business exception is associated with a BusinessCode,
 * which defines the HTTP status, response code and default message.
 */
@Getter
public abstract class BusinessException extends RuntimeException {

    private final BusinessCode businessCode;

    protected BusinessException(BusinessCode businessCode) {
        super(businessCode.getMessage());
        this.businessCode = businessCode;
    }

    protected BusinessException(BusinessCode businessCode, String message) {
        super(message);
        this.businessCode = businessCode;
    }

}