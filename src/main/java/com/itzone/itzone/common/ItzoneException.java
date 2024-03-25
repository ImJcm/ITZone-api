package com.itzone.itzone.common;

public class ItzoneException extends RuntimeException {

    public ItzoneException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

    public ItzoneException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
    }
}
