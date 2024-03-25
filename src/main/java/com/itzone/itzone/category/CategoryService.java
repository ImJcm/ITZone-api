package com.itzone.itzone.category;

import com.itzone.itzone.category.top.TopCategoryListResponseDto;
import com.itzone.itzone.category.top.TopCategoryResponseDto;
import com.itzone.itzone.common.ApiResponseDto;
import org.springframework.stereotype.Service;


@Service
public interface CategoryService {

    ApiResponseDto cretateCategory(CategoryRequestDto CategoryRequestDto);

    ApiResponseDto updateCategory(Long id, CategoryRequestDto CategoryRequestDto);

    ApiResponseDto deleteCategory(Long id);
}
