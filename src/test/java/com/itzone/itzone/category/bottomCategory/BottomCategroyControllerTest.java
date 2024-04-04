package com.itzone.itzone.category.bottomCategory;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itzone.itzone.category.bottom.BoardBottomCategory;
import com.itzone.itzone.category.bottom.BottomCategoryController;
import com.itzone.itzone.category.bottom.BottomCategoryRequestDto;
import com.itzone.itzone.category.bottom.BottomCategoryServiceImpl;
import com.itzone.itzone.category.middle.BoardMiddleCategory;
import com.itzone.itzone.category.top.BoardTopCategory;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BottomCategoryController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class BottomCategroyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
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
    @DisplayName("BottomCategory 생성 컨트롤러 로직 확인")
    void createBottomCategory() throws Exception {
        BoardMiddleCategory middleCategory = new BoardMiddleCategory("중위 카테고리 명", "중위", new BoardTopCategory());
        //given
        BottomCategoryRequestDto req = new BottomCategoryRequestDto(
                boardBottomCategory.getCategoryName(),
                boardBottomCategory.getCategoryClassification(),
                middleCategory
        );

        given(bottomCategoryService.createBottomCategory(any()))
                .willReturn(ApiResponseDto.builder()
                        .message(Message.CATEGORY_CREATE.getMessage())
                        .statusCode(HttpStatus.CREATED.value())
                        .build());

        String json = new ObjectMapper().writeValueAsString(req);

        //when
        ResultActions actions =
                mockMvc.perform(
                        post("/admin/categories/bottom")
                                .contentType(APPLICATION_JSON)
                                .content(json)
                );

        String responseBody = actions.andReturn().getResponse().getContentAsString();

        //then
        actions
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.CREATED.value()))
                .andExpect(jsonPath("$.message").value(Message.CATEGORY_CREATE.getMessage()));
    }
}
