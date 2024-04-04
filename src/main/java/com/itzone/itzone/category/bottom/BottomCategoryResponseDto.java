package com.itzone.itzone.category.bottom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BottomCategoryResponseDto {
    private Long id;

    private String categoryName;

    public BottomCategoryResponseDto(BoardBottomCategory boardBottomCategory){
        this.id = boardBottomCategory.getId();
        this.categoryName = boardBottomCategory.getCategoryName();
    }

}
