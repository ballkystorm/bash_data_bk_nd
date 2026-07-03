package com.asti.bashdata.common.response;


import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Standard error payload returned by the REST API.
 */
@Builder
public record ErrorResponse(

        int status,

        String error,

        String message,

        LocalDateTime timestamp,

        Map<String, String> validationErrors

) {
}