package com.itzone.itzone.board;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itzone.itzone.category.BoardBottomCategory;
import com.itzone.itzone.category.BoardMiddleCategory;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.MessageCode;
import com.itzone.itzone.oauth.OAuthProvider;
import com.itzone.itzone.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockPart;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BoardController.class)
@MockBean(JpaMetamodelMappingContext.class)
class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
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
    @DisplayName("BOARD 생성 컨트롤러 로직 확인")
    void createBoard() throws Exception {
        //given
        List<MultipartFile> files = new ArrayList<>();
        files.add(file);
        BoardRequestDto req = new BoardRequestDto(
                board.getTitle(),
                board.getContent(),
                board.getBottomCategory().getCategoryName(),
                files
        );

        given(boardService.createBoard(any()))
                .willReturn(ApiResponseDto.builder()
                        .message(MessageCode.BOARD_CREATE.getMessage())
                        .statusCode(HttpStatus.CREATED.value())
                        .build());

        //when
        ResultActions actions =
                mockMvc.perform(
                    multipart("/boards")
                        .file("S3files", files.get(0).getBytes())
                        .param("title",req.getTitle())
                        .param("content", req.getContent())
                        .param("category",req.getCategory())
                        .with(requestBoard -> {
                            requestBoard.setMethod("POST");
                            return requestBoard;
                        })
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                );

        //then
        actions
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.CREATED.value()))
                .andExpect(jsonPath("$.message").value(MessageCode.BOARD_CREATE.getMessage()));
    }
}