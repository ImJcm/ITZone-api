package com.itzone.itzone.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ITZoneExceptionHandler {
    @ExceptionHandler(ITZoneException.class)
    public ResponseEntity<ErrorResponse> handleITZoneException(ITZoneException e) {
        return ResponseEntity.status(e.getHttpStatus())
                .body(ErrorResponse.of(e.getMessage(), e.getHttpStatus().value()));
    }
}
