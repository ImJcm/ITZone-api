package com.itzone.itzone.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResponseDto {
    private long id;
    private String title;
    private String content;
    private String writer;
    private String modifiedAt;
    private String category;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getUser().getNickname();
        this.modifiedAt = board.getModifiedAtFormatted();
        this.category = board.getBottomCategory().getCategoryName();
    }
}
