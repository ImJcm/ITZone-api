package com.itzone.itzone.category.top;


import com.itzone.itzone.common.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopCategoryServiceImpl implements  TopCategoryService{

    private final BoardTopCategoryRepository boardTopCategoryRepository;

    public ApiResponseDto cretateTopCategory(TopCategoryRequestDto topCategoryRequestDto){

        String categoryName = topCategoryRequestDto.getCategoryName();

        BoardTopCategory bottomCategory = new BoardTopCategory(categoryName);

        boardTopCategoryRepository.save(bottomCategory);

        return new ApiResponseDto("상위 카테고리리 등록 성공", HttpStatus.CREATED.value());

    }
    //조회
    public TopCategoryListResponseDto getTopCategory() {
        List<TopCategoryResponseDto> boardCategoryList = boardTopCategoryRepository.findAll().stream()
                .map(TopCategoryResponseDto::new)
                .collect(Collectors.toList());

        return new TopCategoryListResponseDto(boardCategoryList);
    }

    //수정
    @Transactional
    public TopCategoryResponseDto updateTopCategory(Long id, TopCategoryRequestDto topCategoryRequestDto){
        BoardTopCategory topCategory = findById(id);
        topCategory.setCategoryName(topCategoryRequestDto.getCategoryName());
        return new TopCategoryResponseDto(topCategory);
    }

    //삭제
    @Transactional
    public ApiResponseDto deleteTopCategory(Long id){
        BoardTopCategory middleCategory = findById(id);
        boardTopCategoryRepository.delete(middleCategory);

        return new ApiResponseDto("상위 카테고리 삭제 성공",HttpStatus.CREATED.value());
    }

    public BoardTopCategory findById(Long id){
        return boardTopCategoryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리를 찾을 수 없습니다.")
        );
    }
}

