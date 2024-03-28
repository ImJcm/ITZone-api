package com.itzone.itzone.category.middle;

import com.itzone.itzone.category.bottom.BottomCategoryListResponseDto;
import com.itzone.itzone.category.bottom.BottomCategoryRequestDto;
import com.itzone.itzone.category.bottom.BottomCategoryResponseDto;
import com.itzone.itzone.common.ApiResponseDto;

public interface MiddleCategoryService {

    ApiResponseDto createMiddleCategory(MiddleCategoryRequestDto middleCategoryRequestDto);

    MiddleCategoryListResponseDto getMiddleCategory();

    MiddleCategoryResponseDto updateMiddleCategory(Long id, MiddleCategoryRequestDto middleCategoryRequestDto);

    ApiResponseDto deleteMiddleCategory(Long id);
}
