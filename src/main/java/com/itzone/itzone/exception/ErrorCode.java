package com.itzone.itzone.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "COMMON-001","유효성 검증에 실패한 경우"),
    INTERVAL_SERVER_ERROR(500, "COMMON-002","서버에서 처리할 수 없는 경우"),

    UNAUTHORIZED(401, "ACCOUNT-001","인증에 실패한 경우"),

    CATEGORY_NOT_EXIST(404,"CATEGORY-001", "카테고리가 존재하지 않는 경우"),
    BOARD_NOT_EXIST(404,"BOARD-001","게시글이 존재하지 않는 경우");

    private final int status;
    private final String code;
    private final String description;
}
