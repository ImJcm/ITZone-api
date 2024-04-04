package com.itzone.itzone.category.middle;


import com.itzone.itzone.category.bottom.BoardBottomCategory;
import com.itzone.itzone.category.top.BoardTopCategory;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.MessageCode;
import com.itzone.itzone.exception.ErrorCode;
import com.itzone.itzone.exception.ITZoneException;
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

        BoardMiddleCategory middleCategory = BoardMiddleCategory.builder()
                .categoryName(middleCategoryRequestDto.getCategoryName())
                .categoryClassification(middleCategoryRequestDto.getCategoryClassification())
                .boardTopCategory(middleCategoryRequestDto.getBoardTopCategory())
                .build();

        boardMiddleCategoryRepository.save(middleCategory);

        return ApiResponseDto.of(MessageCode.CATEGORY_CREATE.getMessage(), HttpStatus.CREATED.value());

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
    public ApiResponseDto updateMiddleCategory(Long id, MiddleCategoryRequestDto middleCategoryRequestDto){
        BoardMiddleCategory middleCategory = findById(id);

        String categoryName = middleCategoryRequestDto.getCategoryName();
        String categoryClassification = middleCategoryRequestDto.getCategoryClassification();
        BoardTopCategory boardTopCategory = middleCategoryRequestDto.getBoardTopCategory();

        middleCategory.update(categoryName, categoryClassification, boardTopCategory);

        return ApiResponseDto.of(MessageCode.CATEGORY_UPDATE.getMessage(), HttpStatus.CREATED.value());
    }

    //삭제
    @Transactional
    public ApiResponseDto deleteMiddleCategory(Long id){
        BoardMiddleCategory middleCategory = findById(id);

        boardMiddleCategoryRepository.delete(middleCategory);

        return ApiResponseDto.of(MessageCode.CATEGORY_DELETE.getMessage(), HttpStatus.CREATED.value());
    }

    public BoardMiddleCategory findById(Long id){
        BoardMiddleCategory boardMiddleCategory = boardMiddleCategoryRepository.findById(id).orElseThrow(
                () -> new ITZoneException(ErrorCode.CATEGORY_NOT_EXIST, HttpStatus.BAD_REQUEST)
        );
        return boardMiddleCategory;
    }
}

