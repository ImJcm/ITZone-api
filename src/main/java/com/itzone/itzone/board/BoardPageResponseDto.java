package com.itzone.itzone.board;

import com.itzone.itzone.common.PageInfo;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
