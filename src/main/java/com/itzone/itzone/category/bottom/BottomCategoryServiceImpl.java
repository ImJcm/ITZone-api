package com.itzone.itzone.category.bottom;


import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BottomCategoryServiceImpl implements BottomCategoryService{

    private final BoardBottomCategoryRepository boardBottomCategoryRepository;

    @Override
    public ApiResponseDto createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto){

        String categoryName = bottomCategoryRequestDto.getCategoryName();

        BoardBottomCategory bottomCategory = new BoardBottomCategory(categoryName);

        boardBottomCategoryRepository.save(bottomCategory);

        return new ApiResponseDto("하위 카테고리리 등록 성공", HttpStatus.CREATED.value());

    }

    //조회
    public BottomCategoryListResponseDto getBottomCategory() {
        List<BottomCategoryResponseDto> bottomCategoryList = boardBottomCategoryRepository.findAll().stream()
                .map(BottomCategoryResponseDto::new)
                .collect(Collectors.toList());

        return new BottomCategoryListResponseDto(bottomCategoryList);
    }

    //수정
    @Transactional
    public BottomCategoryResponseDto updateBottomCategory(Long id, BottomCategoryRequestDto bottomCategoryRequestDto){
        BoardBottomCategory bottomCategory = findById(id);
        bottomCategory.setCategoryName(bottomCategoryRequestDto.getCategoryName());
        return new BottomCategoryResponseDto(bottomCategory);
    }

    //삭제
    public ApiResponseDto deleteBottomCategory(Long id){
        BoardBottomCategory bottomCategory = findById(id);
        boardBottomCategoryRepository.delete(bottomCategory);

        return new ApiResponseDto("하위 카테고리 삭제 성공",HttpStatus.CREATED.value());
    }

    public BoardBottomCategory findById(Long id){
        return boardBottomCategoryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리를 찾을 수 없습니다.")
        );
    }
}

