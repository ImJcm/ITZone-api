package com.itzone.itzone.common;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponseDto {
    String message;
    int statusCode;

    public static ApiResponseDto of(String message, int statusCode) {
        return ApiResponseDto.builder()
                .message(message)
                .statusCode(statusCode)
                .build();
    }
}
