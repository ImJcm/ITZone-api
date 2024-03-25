package com.itzone.itzone.category.top;

import lombok.Getter;

import java.util.List;

@Getter
public class TopCategoryListResponseDto {
    private List<TopCategoryResponseDto> topCategoryList;
    public TopCategoryListResponseDto(List<TopCategoryResponseDto> topCategoryList){
        this.topCategoryList = topCategoryList;
    }
}
