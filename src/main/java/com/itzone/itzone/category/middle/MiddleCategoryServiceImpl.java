package com.itzone.itzone.category.middle;


import com.itzone.itzone.common.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MiddleCategoryServiceImpl implements MiddleCategoryService {

    private final BoardMiddleCategoryRepository boardMiddleCategoryRepository;

    public ApiResponseDto createMiddleCategory(MiddleCategoryRequestDto middleCategoryRequestDto){

        String categoryName = middleCategoryRequestDto.getCategoryName();

        BoardMiddleCategory bottomCategory = new BoardMiddleCategory(categoryName);

        boardMiddleCategoryRepository.save(bottomCategory);

        return new ApiResponseDto("중위 카테고리리 등록 성공", HttpStatus.CREATED.value());

    }
    //조회
    public MiddleCategoryListResponseDto getMiddleCategory() {
        List<MiddleCategoryResponseDto> middleCategoryList = boardMiddleCategoryRepository.findAll().stream()
                .map(MiddleCategoryResponseDto::new)
                .collect(Collectors.toList());

        return new MiddleCategoryListResponseDto(middleCategoryList);
    }

    //수정
    @Transactional
    public MiddleCategoryResponseDto updateMiddleCategory(Long id, MiddleCategoryRequestDto middleCategoryRequestDto){
        BoardMiddleCategory middleCategory = findById(id);

        middleCategory.setCategoryName(middleCategoryRequestDto.getCategoryName());

        return new MiddleCategoryResponseDto(middleCategory);
    }

    //삭제
    @Transactional
    public ApiResponseDto deleteMiddleCategory(Long id){
        BoardMiddleCategory middleCategory = findById(id);

        boardMiddleCategoryRepository.delete(middleCategory);

        return new ApiResponseDto("중위 카테고리 삭제 성공",HttpStatus.CREATED.value());
    }

    public BoardMiddleCategory findById(Long id){
        return boardMiddleCategoryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리를 찾을 수 없습니다.")
        );
    }
}

