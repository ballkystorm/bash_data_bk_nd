package com.asti.bashdata.common.codes;

import org.springframework.http.HttpStatus;

/**
 * Defines the contract for all business response codes exposed by the application.
 */
public interface BusinessCode {

    HttpStatus getHttpStatus();

    String getCode();

    String getMessage();

}