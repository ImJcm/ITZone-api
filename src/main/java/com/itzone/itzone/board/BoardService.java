package com.itzone.itzone.board;

import com.itzone.itzone.common.ApiResponseDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {
    /**
     * 게시글 생성
     *
     * @param requestDto
     * @return
     */
    ApiResponseDto createBoard(BoardRequestDto requestDto);
}
