package com.itzone.itzone.category.middle;

import com.itzone.itzone.category.top.BoardTopCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MiddleCategoryRequestDto {

    @NotBlank(message = "카테고리명을 입력해주세요.")
    private String categoryName;

    @NotBlank(message = "카테고리 분류를 입력해주세요")
    private String categoryClassification;

    @NotBlank(message = "상위 카테고리명을 입력하세요")
    private BoardTopCategory boardTopCategory;
}
