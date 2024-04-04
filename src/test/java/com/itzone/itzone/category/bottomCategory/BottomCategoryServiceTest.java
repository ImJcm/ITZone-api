package com.itzone.itzone.category.bottomCategory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itzone.itzone.board.Board;
import com.itzone.itzone.board.BoardRequestDto;
import com.itzone.itzone.category.bottom.BoardBottomCategory;
import com.itzone.itzone.category.bottom.BoardBottomCategoryRepository;
import com.itzone.itzone.category.bottom.BottomCategoryRequestDto;
import com.itzone.itzone.category.bottom.BottomCategoryServiceImpl;
import com.itzone.itzone.category.middle.BoardMiddleCategory;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BottomCategoryServiceTest {
    @Mock
    private BoardBottomCategoryRepository bottomCategoryRepository;

    @InjectMocks
    private BottomCategoryServiceImpl bottomCategoryService;

    private ObjectMapper objectMapper;

    private static BoardBottomCategory boardBottomCategory;


    @BeforeEach
    void setup() throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD,
                JsonAutoDetect.Visibility.ANY);

        boardBottomCategory = BoardBottomCategory.builder()
                .categoryName("하위 게시판 이름")
                .categoryClassification("하위 게시판")
                .boardMiddleCategory(new BoardMiddleCategory())
                .build();
    }

    @Test
    @DisplayName("bottomCategory 생성 성공")
    void createBottomCategorySucess() {
        //given
        BottomCategoryRequestDto req = new BottomCategoryRequestDto(
                boardBottomCategory.getCategoryName(),
                boardBottomCategory.getCategoryClassification(),
                boardBottomCategory.getBoardMiddleCategory()
        );
        given(bottomCategoryRepository.save(any(BoardBottomCategory.class))).willReturn(boardBottomCategory);

        //when
        ApiResponseDto result = bottomCategoryService.createBottomCategory(req);

        //then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED.value());
        Assertions.assertThat(result.getMessage()).isEqualTo(Message.CATEGORY_CREATE.getMessage());
    }
}
