package com.itzone.itzone.category.top;

import com.itzone.itzone.category.middle.MiddleCategoryListResponseDto;
import com.itzone.itzone.category.middle.MiddleCategoryRequestDto;
import com.itzone.itzone.category.middle.MiddleCategoryResponseDto;
import com.itzone.itzone.common.ApiResponseDto;

public interface TopCategoryService {

    ApiResponseDto createTopCategory(TopCategoryRequestDto topCategoryRequestDto);

    TopCategoryListResponseDto getTopCategory();

    TopCategoryResponseDto updateTopCategory(Long id, TopCategoryRequestDto topCategoryRequestDto);

    ApiResponseDto deleteTopCategory(Long id);
}
