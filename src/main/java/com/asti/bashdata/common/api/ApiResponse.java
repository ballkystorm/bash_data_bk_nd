package com.asti.bashdata.common.api;

import com.asti.bashdata.common.codes.BusinessSuccess;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Standard API response returned for successful requests.
 *
 * @param <T> response payload type
 */
@Getter
@Builder(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    /**
     * Indicates whether the request was successful.
     */
    private final boolean success;

    /**
     * Business success code.
     */
    private final String code;

    /**
     * Success message.
     */
    private final String message;

    /**
     * Time the response was generated.
     */
    private final LocalDateTime timestamp;

    /**
     * Response payload.
     */
    private final T data;

    /**
     * Creates a successful API response.
     *
     * @param businessSuccess business success
     * @param data response payload
     * @return standardized API response
     */
    public static <T> ApiResponse<T> success(
            BusinessSuccess businessSuccess,
            T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .code(businessSuccess.getCode())
                .message(businessSuccess.getMessage())
                .timestamp(LocalDateTime.now())
                .data(data)
                .build();
    }

}