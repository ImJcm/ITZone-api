package com.itzone.itzone.board;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itzone.itzone.category.BoardBottomCategory;
import com.itzone.itzone.category.BoardMiddleCategory;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.Message;
import com.itzone.itzone.oauth.OAuthProvider;
import com.itzone.itzone.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardServiceImpl boardService;

    private ObjectMapper objectMapper;

    private static Board board;
    private static User user;
    private static BoardBottomCategory boardBottomCategory;
    private static MockMultipartFile file;

    @BeforeEach
    void setup() throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD,
                JsonAutoDetect.Visibility.ANY);

        user = User.builder()
                .email("test@email.com")
                .nickname("tester")
                .password("1234")
                .oAuthProvider(OAuthProvider.KAKAO)
                .build();

        boardBottomCategory = new BoardBottomCategory();
        boardBottomCategory.setId(1L);
        boardBottomCategory.setCategoryName("테스트 하위 카테고리명");
        boardBottomCategory.setBoardMiddleCategory(new BoardMiddleCategory());

        file = new MockMultipartFile(
                "image",
                "image.png",
                MediaType.IMAGE_PNG_VALUE,
                "board/2024/03/31/image.png".getBytes());


        board = Board.builder()
                .title("테스트 게시글 제목")
                .content("테스트 게시글 내용")
                .user(user)
                .bbc(boardBottomCategory)
                .build();
    }

    @Test
    @DisplayName("board 생성 성공")
    void createBoardSuccess() {
        //given
        List<MultipartFile> files = new ArrayList<>();
        files.add(file);
        BoardRequestDto req = new BoardRequestDto(
                board.getTitle(),
                board.getContent(),
                board.getBottomCategory().getCategoryName(),
                files
        );
        given(boardRepository.save(any(Board.class))).willReturn(board);

        //when
        ApiResponseDto result = boardService.createBoard(req);

        //then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED.value());
        Assertions.assertThat(result.getMessage()).isEqualTo(Message.BOARD_CREATE.getMessage());
    }


}