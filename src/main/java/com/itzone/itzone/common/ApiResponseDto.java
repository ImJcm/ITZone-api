package com.itzone.itzone.common;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponseDto {
    String message;
    int statusCode;

    @Builder
    public ApiResponseDto(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
    public static ApiResponseDto of(String message, int statusCode) {
        return ApiResponseDto.builder()
                .message(message)
                .statusCode(statusCode)
                .build();
    }
}
