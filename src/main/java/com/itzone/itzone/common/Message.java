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

    CATEGORY_CREATE("카테고리 생성 성공"),
    CATEGORY_UPDATE("카테고리 수정 성공"),
    CATEGORY_DELTE("카테고리 삭제 성공"),
    /**
     * Error Message
     */
    CATEGORY_NOT_EXIST("존재하지 않는 카테고리입니다."),
    BOARD_NOT_EXIST("존재하지 않는 게시글입니다.");
    
    


    private final String message;
}
