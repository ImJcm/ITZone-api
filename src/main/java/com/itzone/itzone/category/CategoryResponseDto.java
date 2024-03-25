package com.itzone.itzone.category;

import com.itzone.itzone.category.top.BoardTopCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDto {
    private Long id;
    private String categoryName;

    public CategoryResponseDto(Category category){
        this.id = category.getCategoryId();
        this.categoryName = category.getCategoryName();
    }

}
