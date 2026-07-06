package com.asti.bashdata.common.exception;

import com.asti.bashdata.common.codes.BusinessError;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles exceptions thrown across the application and converts them
 * into standardized API error responses.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
            BusinessException ex) {

        BusinessError error = ex.getError();

        log.warn("{} : {}", error.getCode(), error.getMessage());

        return ResponseEntity
                .status(error.getStatus())
                .body(buildErrorResponse(error, null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {

        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            validationErrors.put(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            );
        }

        return ResponseEntity
                .status(BusinessError.VALIDATION_FAILED.getStatus())
                .body(buildErrorResponse(
                        BusinessError.VALIDATION_FAILED,
                        validationErrors
                ));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
            ConstraintViolationException ex) {

        log.warn("Constraint violation: {}", ex.getMessage());

        return ResponseEntity
                .status(BusinessError.VALIDATION_FAILED.getStatus())
                .body(buildErrorResponse(
                        BusinessError.VALIDATION_FAILED,
                        null
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {

        log.error("Unexpected exception", ex);

        return ResponseEntity
                .status(BusinessError.INTERNAL_SERVER_ERROR.getStatus())
                .body(buildErrorResponse(
                        BusinessError.INTERNAL_SERVER_ERROR,
                        null
                ));
    }

    /**
     * Builds a standardized error response.
     *
     * @param error business error
     * @param validationErrors validation errors if present
     * @return error response
     */
    private ErrorResponse buildErrorResponse(
            BusinessError error,
            Map<String, String> validationErrors) {

        return ErrorResponse.builder()
                .status(error.getStatus().value())
                .code(error.getCode())
                .message(error.getMessage())
                .timestamp(LocalDateTime.now())
                .validationErrors(validationErrors)
                .build();
    }

}