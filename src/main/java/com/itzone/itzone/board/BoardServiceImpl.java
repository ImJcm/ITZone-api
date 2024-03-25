package com.itzone.itzone.board;

import com.itzone.itzone.awsS3.S3File;
import com.itzone.itzone.category.BoardBottomCategory;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.MessageCode;
import com.itzone.itzone.exception.ErrorCode;
import com.itzone.itzone.exception.ITZoneException;
import com.itzone.itzone.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    /**
     * 게시글 생성
     *
     * @AuthenticationPrincipal oAuth User 필요
     * Category ID에 해당하는 category Object 필요
     * S3Files 저장할 AWS S3 Service 필요
     *
     * @param requestDto 게시글 작성 요청 데이터
     * @return           요청 처리 결과
     */
    @Override
    public ApiResponseDto createBoard(BoardRequestDto requestDto) {
        Board board = Board.builder()
                        //.user()
                        .title(requestDto.getTitle())
                        .content(requestDto.getContent())
                        //.bbc(requestDto.getCategory())
                        .build();

        boardRepository.save(board);

        return ApiResponseDto.of(MessageCode.BOARD_CREATE.getMessage(), HttpStatus.CREATED.value());
    }

    /**
     * 게시글 전체 조회
     *
     * @return 요청 처리 결과
     */
    @Transactional
    @Override
    public Page<BoardResponseDto> readBoards(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Board> boardList = boardRepository.findAll(pageable);

        return boardList.map(BoardResponseDto::new);
    }

    /**
     * 게시글 단일 조회
     *
     * @param id 게시글 id
     * @return   요청 처리 결과
     */
    @Override
    public BoardResponseDto readBoard(Long id) {
        Board board = findBoardById(id);

        return new BoardResponseDto(board);
    }

    /**
     * 게시글 수정
     *
     * @AuthenticationPrincipal OAuth User 필요
     * BottomCategory 필요
     *
     * @param id         게시글 id
     * @param requestDto 게시글 수정 요청 사항
     * @return           요청 처리 결과
     */
    @Transactional
    @Override
    public ApiResponseDto updateBoard(long id, BoardRequestDto requestDto) {
        Board board = findBoardById(id);

        String newTitle = requestDto.getTitle();
        String newContent = requestDto.getContent();

        board.update(newTitle, newContent);

        return ApiResponseDto.of(MessageCode.BOARD_UPDATE.getMessage(), HttpStatus.OK.value());
    }

    /**
     * 게시글 삭제
     *
     * @AuthenticationPrincipal oAuth User 필요
     *
     * @param id    게시글 id
     * @return      요청 처리 결과
     */
    @Override
    public ApiResponseDto deleteBoard(long id) {
        Board board = findBoardById(id);

        boardRepository.delete(board);

        return new ApiResponseDto(MessageCode.BOARD_DELETE.getMessage(), HttpStatus.OK.value());

    }

    /**
     * 게시글 찾기 by boardId
     *
     * @param id    게시글 id
     * @return      요청 처리 결과
     */
    @Override
    public Board findBoardById(long id) {
        Board board = boardRepository.findById(id).orElseThrow(()
                -> new ITZoneException(ErrorCode.BOARD_NOT_EXIST,HttpStatus.BAD_REQUEST));
        return board;
    }
}
