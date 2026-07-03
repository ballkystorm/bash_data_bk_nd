package com.asti.bashdata.common.api;

import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Standard API response returned by all REST endpoints.
 *
 * @param <T> the type of the response payload
 */
@Builder
public record ApiResponse<T>(

        boolean success,

        String message,

        T data,

        LocalDateTime timestamp

) {

    /**
     * Creates a successful API response.
     */
    public static <T> ApiResponse<T> success(String message, T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * Creates a successful API response without a payload.
     */
    public static ApiResponse<Void> success(String message) {

        return ApiResponse.<Void>builder()
                .success(true)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * Creates a failed API response.
     */
    public static ApiResponse<Void> failure(String message) {

        return ApiResponse.<Void>builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

}
