package com.itzone.itzone.category.middle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MiddleCategoryResponseDto {
    private Long id;

    private String categoryName;

    public MiddleCategoryResponseDto(BoardMiddleCategory boardMiddleCategory){
        this.id = boardMiddleCategory.getId();
        this.categoryName = boardMiddleCategory.getCategoryName();
    }

}
