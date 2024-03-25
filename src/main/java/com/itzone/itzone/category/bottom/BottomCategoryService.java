package com.itzone.itzone.category.bottom;

import com.itzone.itzone.common.ApiResponseDto;

public interface BottomCategoryService {

    ApiResponseDto createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto);

    BottomCategoryListResponseDto getBottomCategory();

    BottomCategoryResponseDto updateBottomCategory(Long id, BottomCategoryResponseDto bottomCategoryResponseDto);

    ApiResponseDto deleteBottomCategory(Long id);
}
