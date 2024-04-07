package com.itzone.itzone.board;

import com.itzone.itzone.common.PageInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BoardPageResponseDto {
    List<BoardResponseDto> content;
    PageInfo pageInfo;

    public static BoardPageResponseDto of(List<BoardResponseDto> content, PageInfo pageInfo) {
        return BoardPageResponseDto.builder()
                .content(content)
                .pageInfo(pageInfo)
                .build();
    }
}
