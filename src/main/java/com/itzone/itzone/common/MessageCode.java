package com.itzone.itzone.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageCode {
    BOARD_CREATE("message.board.create"),
    BOARD_UPDATE("message.board.update"),
    BOARD_DELETE("message.board.delete");
    
    private final String message;
}
