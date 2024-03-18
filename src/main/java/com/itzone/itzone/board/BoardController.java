package com.itzone.itzone.board;

import com.itzone.itzone.common.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardServiceImpl boardService;

    /*
     * 게시판 생성
     */
    @PostMapping()
    public ResponseEntity<ApiResponseDto> createBoard(@ModelAttribute BoardRequestDto requestDto) {
        ApiResponseDto result = boardService.createBoard(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
