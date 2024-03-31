package com.itzone.itzone.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ITZoneExceptionHandler {
    /**
     * ITZone 서비스 내부 커스텀 예외처리
     *
     * @param e     커스텀 예외 Class
     * @return      ErrorResponse
     */
    @ExceptionHandler(ITZoneException.class)
    public ResponseEntity<ErrorResponse> handleITZoneException(ITZoneException e) {
        return ResponseEntity.status(e.getHttpStatus())
                .body(ErrorResponse.of(e.getMessage(), e.getHttpStatus().value()));
    }
}
