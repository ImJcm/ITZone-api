package com.itzone.itzone.category;

import com.itzone.itzone.category.top.TopCategoryResponseDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryListResponseDto {
    private List<TopCategoryResponseDto> topCategoryList;
    public CategoryListResponseDto(List<TopCategoryResponseDto> topCategoryList){
        this.topCategoryList = topCategoryList;
    }
}
