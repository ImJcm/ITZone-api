package com.itzone.itzone.category.bottom;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
public class BottomCategoryRequestDto {

    @NotBlank(message = "카테고리명을 입력해주세요.")
    private String categoryName;

    @NotBlank(message = "카테고리 분류를 입력해주세요")
    private String categoryClassification;

    @NotBlank(message = "중위 카테고리명을 입력하세요")
    private String categoryMiddle;


}
