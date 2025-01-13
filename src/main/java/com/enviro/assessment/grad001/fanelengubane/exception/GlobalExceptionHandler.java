package com.enviro.assessment.grad001.fanelengubane.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler to handle exceptions across the whole application.
 * This class uses @ControllerAdvice to apply to all controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles RuntimeExceptions thrown by any controller method.
     *
     * @param ex the RuntimeException that was thrown
     * @return ResponseEntity containing the exception message and HTTP status NOT_FOUND
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        // Return a response entity with HTTP status 404 (NOT FOUND) and the exception message as the body
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}