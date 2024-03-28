package com.itzone.itzone.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    String errorMessage;
    int statusCode;

    @Builder
    public ErrorResponse(String errorMessage, int statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }

    public static ErrorResponse of(String errorMessage, int statusCode) {
        return ErrorResponse.builder()
                .errorMessage(errorMessage)
                .statusCode(statusCode)
                .build();
    }
}
