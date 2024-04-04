package com.itzone.itzone.category.bottomCategory;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itzone.itzone.category.bottom.BoardBottomCategory;
import com.itzone.itzone.category.bottom.BoardBottomCategoryRepository;
import com.itzone.itzone.category.middle.BoardMiddleCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BottomCategoryRepositoryTest {

    @Autowired
    private BoardBottomCategoryRepository bottomCategoryRepository;

    private ObjectMapper objectMapper;

    private static BoardBottomCategory boardBottomCategory;

    @BeforeEach
    void setup() throws IOException{
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
    @DisplayName("bottomCategory 카테고리 생성")
    public void createBottomCategory(){
        //given
        //setup Category 사용

        //when
        BoardBottomCategory saveCategory = bottomCategoryRepository.save(boardBottomCategory);

        //then
        assertNotNull(saveCategory);
        assertEquals(boardBottomCategory.getCategoryName(), saveCategory.getCategoryName());
        assertEquals(boardBottomCategory.getCategoryClassification(), saveCategory.getCategoryClassification());
        assertEquals(boardBottomCategory.getBoardMiddleCategory(), saveCategory.getBoardMiddleCategory());
    }

}
