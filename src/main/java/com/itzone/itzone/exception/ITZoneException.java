package com.itzone.itzone.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ITZoneException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public ITZoneException(ErrorCode errorCode, String message) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
