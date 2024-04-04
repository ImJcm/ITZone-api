package com.itzone.itzone.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageCode {
    BOARD_CREATE("message.board.create"),
    BOARD_UPDATE("message.board.update"),
    BOARD_DELETE("message.board.delete"),

    CATEGORY_CREATE("message.category.create"),
    CATEGORY_UPDATE("message.category.update"),
    CATEGORY_DELETE("message.category.delete");
    private final String message;
}
