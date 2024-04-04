package com.itzone.itzone.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {
    /**
     * Message
     */
    BOARD_CREATE("게시글 생성 성공"),
    BOARD_UPDATE("게시글 수정 성공"),
    BOARD_DELETE("게시글 삭제 성공"),

    /**
     * Error Message
     */
    BOARD_NOT_EXIST("존재하지 않는 게시글입니다.");


    private final String message;
}
