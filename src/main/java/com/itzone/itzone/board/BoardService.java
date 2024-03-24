package com.itzone.itzone.board;

import com.itzone.itzone.common.ApiResponseDto;
import org.springframework.data.domain.Page;

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

    /**
     * 게시글 수정
     *
     * @param id
     * @param requestDto
     * @return
     */
    ApiResponseDto updateBoard(long id, BoardRequestDto requestDto);

    /**
     * 게시글 삭제
     *
     * @param id
     * @return
     */
    ApiResponseDto deleteBoard(long id);

    /**
     * 게시글 찾기 by boardId
     *
     */
    Board findBoardById(long id);
}
