package com.itzone.itzone.category.bottomCategory;


import com.itzone.itzone.category.bottom.BoardBottomCategory;
import com.itzone.itzone.category.bottom.BoardBottomCategoryRepository;
import com.itzone.itzone.category.bottom.BottomCategoryRequestDto;
import com.itzone.itzone.category.bottom.BottomCategoryService;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.user.User;
import com.itzone.itzone.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class BottomCategoryTest {

    @Autowired
    private BottomCategoryService bottomCategoryService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardBottomCategoryRepository boardBottomCategoryRepository;

    private User user;


    @Test
    void 하위_카테고리_생성_성공(){
        BottomCategoryRequestDto requestDto = new BottomCategoryRequestDto("자유게시판", "미들", "중위 게시판");
        ApiResponseDto bottomCategory = bottomCategoryService.createBottomCategory(requestDto);

        BoardBottomCategory category = boardBottomCategoryRepository.findAll().get(0);
        assertThat(category.getCategoryName()).isEqualTo("자유게시판");
    }
}
