package com.itzone.itzone.exception;

import lombok.Builder;
import lombok.Getter;
import org.aspectj.apache.bcel.classfile.Code;

@Getter
public class ErrorResponse {
    String code;
    String message;

    @Builder
    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorResponse of(ErrorCode errorCode, String message) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .message(message)
                .build();
    }
}
