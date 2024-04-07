package com.itzone.itzone.category.bottom;


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
public class BottomCategoryServiceImpl implements BottomCategoryService{

    private final BoardBottomCategoryRepository boardBottomCategoryRepository;

    @Override
    public ApiResponseDto createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto){

        BoardBottomCategory bottomCategory = BoardBottomCategory.builder()
                .categoryName(bottomCategoryRequestDto.getCategoryName())
                .categoryClassification(bottomCategoryRequestDto.getCategoryClassification())
                .boardMiddleCategory(bottomCategoryRequestDto.getBoardMiddleCategory())
                .build();

        boardBottomCategoryRepository.save(bottomCategory);

        return ApiResponseDto.of(Message.CATEGORY_CREATE.getMessage(), HttpStatus.CREATED.value());

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
    @Override
    public ApiResponseDto updateBottomCategory(Long id, BottomCategoryRequestDto bottomCategoryRequestDto){
        BoardBottomCategory bottomCategory = findById(id);

        String categoryName = bottomCategoryRequestDto.getCategoryName();
        String categoryClassification = bottomCategoryRequestDto.getCategoryClassification();
        BoardMiddleCategory boardMiddleCategory = bottomCategoryRequestDto.getBoardMiddleCategory();

        bottomCategory.update(categoryName, categoryClassification, boardMiddleCategory);

        return ApiResponseDto.of(Message.CATEGORY_UPDATE.getMessage(), HttpStatus.OK.value());
    }

    //삭제
    public ApiResponseDto deleteBottomCategory(Long id){
        BoardBottomCategory bottomCategory = findById(id);

        boardBottomCategoryRepository.delete(bottomCategory);

        return new ApiResponseDto(Message.CATEGORY_DELTE.getMessage(), HttpStatus.NO_CONTENT.value());
    }

    public BoardBottomCategory findById(Long id){
        BoardBottomCategory boardBottomCategory = boardBottomCategoryRepository.findById(id).orElseThrow(
                () -> new ITZoneException(ErrorCode.CATEGORY_NOT_EXIST, Message.CATEGORY_NOT_EXIST.getMessage())
        );
        return boardBottomCategory;
    }

    public BoardBottomCategory findByCategoryName(String categoryName) {
        BoardBottomCategory boardBottomCategory = boardBottomCategoryRepository.findByCategoryName(categoryName).orElseThrow(
                () -> new ITZoneException(ErrorCode.CATEGORY_NOT_EXIST, Message.CATEGORY_NOT_EXIST.getMessage())
        );
        return boardBottomCategory;
    }
}

