package com.itzone.itzone.category.top;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopCategoryResponseDto {
    private Long id;

    private String categoryName;

    public TopCategoryResponseDto(BoardTopCategory boardTopCategory){
        this.id = boardTopCategory.getId();
        this.categoryName = boardTopCategory.getCategoryName();
    }

}
