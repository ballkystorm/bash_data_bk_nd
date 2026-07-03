package com.asti.bashdata.common.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles exceptions thrown across the application and
 * converts them into consistent API responses.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {

        log.warn("Resource not found: {}", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildError(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateResourceException ex) {

        log.warn("Duplicate resource: {}", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(buildError(
                        HttpStatus.CONFLICT,
                        ex.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {

        return ResponseEntity.badRequest()
                .body(buildError(
                        HttpStatus.BAD_REQUEST,
                        ex.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            validationErrors.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.badRequest()
                .body(buildError(
                        HttpStatus.BAD_REQUEST,
                        "Validation failed.",
                        validationErrors
                ));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex) {

        return ResponseEntity.badRequest()
                .body(buildError(
                        HttpStatus.BAD_REQUEST,
                        ex.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception ex) {

        log.error("Unexpected error", ex);

        return ResponseEntity.internalServerError()
                .body(buildError(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "An unexpected error occurred.",
                        null
                ));
    }

    private ErrorResponse buildError(
            HttpStatus status,
            String message,
            Map<String, String> validationErrors) {

        return ErrorResponse.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .timestamp(LocalDateTime.now())
                .validationErrors(validationErrors)
                .build();
    }

}