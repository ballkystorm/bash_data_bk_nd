package com.asti.bashdata.common.exception;

import com.asti.bashdata.common.codes.BusinessCode;

/**
 * Thrown when a requested resource does not exist.
 */
public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(BusinessCode businessCode) {
        super(businessCode);
    }

    public ResourceNotFoundException(BusinessCode businessCode, String message) {
        super(businessCode, message);
    }

}