package com.itzone.itzone.category.middle;

import lombok.Getter;

import java.util.List;

@Getter
public class MiddleCategoryListResponseDto {
    private List<MiddleCategoryResponseDto> middleCategoryList;
    public MiddleCategoryListResponseDto(List<MiddleCategoryResponseDto> middleCategoryList){
        this.middleCategoryList = middleCategoryList;
    }
}
