package com.itzone.itzone.board;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itzone.itzone.category.BoardBottomCategory;
import com.itzone.itzone.category.BoardMiddleCategory;
import com.itzone.itzone.oauth.OAuthProvider;
import com.itzone.itzone.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

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
    @DisplayName("board 생성")
    public void createBoard() {
        //given
        //setup - board 사용

        //when
        Board savedBoard = boardRepository.save(board);

        //then
        Assertions.assertNotNull(savedBoard);
        Assertions.assertEquals(board.getTitle(), savedBoard.getTitle());
        Assertions.assertEquals(board.getContent(), savedBoard.getContent());
        Assertions.assertEquals(board.getUser(), savedBoard.getUser());
        Assertions.assertEquals(board.getBottomCategory(), savedBoard.getBottomCategory());
    }
}
