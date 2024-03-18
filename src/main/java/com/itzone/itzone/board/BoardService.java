package com.itzone.itzone.board;

import com.itzone.itzone.common.ApiResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BoardService {
    /**
     * 게시글 생성
     *
     * @param requestDto
     * @return
     */
    ApiResponseDto createBoard(BoardRequestDto requestDto);

    /**
     * 게시글 전체 조회 (페이징)
     *
     * @return
     */
    Page<BoardResponseDto> readBoards(int page, int size);


    /**
     * 게시글 단일 조회
     *
     * @param id
     * @return
     */
    BoardResponseDto readBoard(Long id);
}
