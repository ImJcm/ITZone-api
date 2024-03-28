package com.itzone.itzone.category.top;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopCategoryRequestDto {

    @NotBlank(message = "카테고리명을 입력해주세요.")
    private String categoryName;

    @NotBlank(message = "카테고리 분류를 입력해주세요")
    private String categoryClassification;

}
