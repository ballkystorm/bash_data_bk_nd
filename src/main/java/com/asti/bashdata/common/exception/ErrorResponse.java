package com.asti.bashdata.common.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Standard error response returned by the API.
 */
@Getter
@Builder
public class ErrorResponse {

    private final int status;

    private final String code;

    private final String message;

    private final LocalDateTime timestamp;

    private final Map<String, String> validationErrors;

}