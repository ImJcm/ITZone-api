package com.itzone.itzone.board;

import com.itzone.itzone.common.ApiResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardServiceImpl boardService;

    /**
     * 게시글 생성
     */
    @PostMapping
    public ResponseEntity<ApiResponseDto> createBoard(@ModelAttribute @Valid BoardRequestDto requestDto) {
        ApiResponseDto result = boardService.createBoard(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * 게시글 전체 조회 (페이징 처리)
     */
    @GetMapping
    public ResponseEntity<BoardPageResponseDto> readBoards(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        BoardPageResponseDto result = boardService.readBoards(page - 1, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * 게시글 단일 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDto> readBoard(@PathVariable Long id) {
        BoardResponseDto result = boardService.readBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * 게시글 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto> updateBoard(
            @PathVariable long id,
            @ModelAttribute @Valid BoardRequestDto requestDto) {
        ApiResponseDto result = boardService.updateBoard(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto> deleteBoard(@PathVariable long id) {
        ApiResponseDto result = boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
