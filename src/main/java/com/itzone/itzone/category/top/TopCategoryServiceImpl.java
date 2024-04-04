package com.itzone.itzone.category.top;


import com.itzone.itzone.category.middle.BoardMiddleCategory;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.Message;
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
public class TopCategoryServiceImpl implements TopCategoryService{

    private final BoardTopCategoryRepository boardTopCategoryRepository;

    public ApiResponseDto createTopCategory(TopCategoryRequestDto topCategoryRequestDto){

        BoardTopCategory topCategory = BoardTopCategory.builder()
                .categoryName(topCategoryRequestDto.getCategoryName())
                .categoryClassification(topCategoryRequestDto.getCategoryClassification())
                .build();

        boardTopCategoryRepository.save(topCategory);

        return new ApiResponseDto(Message.CATEGORY_CREATE.getMessage(), HttpStatus.CREATED.value());

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
    public ApiResponseDto updateTopCategory(Long id, TopCategoryRequestDto topCategoryRequestDto){
        BoardTopCategory topCategory = findById(id);

        String categoryName = topCategoryRequestDto.getCategoryName();
        String categoryClassification = topCategoryRequestDto.getCategoryClassification();

        topCategory.update(categoryName, categoryClassification);


        return ApiResponseDto.of(Message.CATEGORY_UPDATE.getMessage(), HttpStatus.OK.value());
    }

    //삭제
    @Transactional
    public ApiResponseDto deleteTopCategory(Long id){
        BoardTopCategory middleCategory = findById(id);

        boardTopCategoryRepository.delete(middleCategory);

        return ApiResponseDto.of(Message.CATEGORY_DELTE.getMessage(), HttpStatus.NO_CONTENT.value());
    }

    public BoardTopCategory findById(Long id){
        BoardTopCategory boardTopCategory = boardTopCategoryRepository.findById(id).orElseThrow(
                () -> new ITZoneException(ErrorCode.CATEGORY_NOT_EXIST, Message.CATEGORY_NOT_EXIST.getMessage())
        );
        return boardTopCategory;
    }
}

