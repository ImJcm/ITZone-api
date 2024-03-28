package com.itzone.itzone.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ITZoneException extends RuntimeException {
    private ErrorCode errorCode;
    private HttpStatus httpStatus;

    public ITZoneException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
