package com.itzone.itzone.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    BOARD_NOT_EXIST("error.board.not.exist"),
    BOARD_TITLE_BLANK("error.board.title.blank"),
    BOARD_CONTENT_BLANK("error.board.content.blank"),
    BOARD_CATEGORY_UNSELECT("error.board.category.unselect"),
    CREATE_ERROR("error.create"),
    UPDATE_ERROR("error.update");

    private final String message;
}
