package com.itzone.itzone.board;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponseDto {
    private long id;
    private String title;
    private String content;
    private String writer;
    private String modifiedAt;
    private String category;

    public static BoardResponseDto of(Board board) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getUser().getNickname())
                .modifiedAt(board.getModifiedAtFormatted())
                .category(board.getBottomCategory().getCategoryName())
                .build();
    }
}
