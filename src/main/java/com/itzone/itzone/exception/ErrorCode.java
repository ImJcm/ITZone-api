package com.itzone.itzone.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    BOARD_NOT_EXIST("error.board.not.exist"),
    CREATE_ERROR("error.create"),
    UPDATE_ERROR("error.update");

    private final String message;
}
