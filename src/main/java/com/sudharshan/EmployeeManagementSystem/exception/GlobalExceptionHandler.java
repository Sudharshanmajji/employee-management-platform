package com.sudharshan.EmployeeManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException exception)
    {
        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(404)
                .error("Not Found")
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(
                apiError,
                HttpStatus.NOT_FOUND
        );
    }
}
