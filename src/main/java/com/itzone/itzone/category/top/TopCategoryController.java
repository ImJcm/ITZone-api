package com.itzone.itzone.category.top;

import com.itzone.itzone.category.middle.MiddleCategoryListResponseDto;
import com.itzone.itzone.category.middle.MiddleCategoryRequestDto;
import com.itzone.itzone.category.middle.MiddleCategoryResponseDto;
import com.itzone.itzone.category.middle.MiddleCategoryServiceImpl;
import com.itzone.itzone.common.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TopCategoryController {

    private final TopCategoryServiceImpl topCategoryService;
    //생성
    @PostMapping("/admin/categories/top")
    public ResponseEntity<ApiResponseDto> createCategory(@ModelAttribute TopCategoryRequestDto topCategoryRequestDto) {

        ApiResponseDto result = topCategoryService.createTopCategory(topCategoryRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //조회
    @GetMapping("/categories/top")
    public ResponseEntity<TopCategoryListResponseDto> readCategory(){

        TopCategoryListResponseDto topCategory = topCategoryService.getTopCategory();

        return ResponseEntity.status(HttpStatus.OK).body(topCategory);
    }

    //수정
    @PutMapping("/admin/categories/top/{id}")
    public ResponseEntity<ApiResponseDto> updateMiddleCategory(@PathVariable Long id, @RequestBody TopCategoryRequestDto topCategoryRequestDto) {

        ApiResponseDto result = topCategoryService.updateTopCategory(id, topCategoryRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //삭제
    @DeleteMapping("/admin/categories/top/{id}")
    public ResponseEntity<ApiResponseDto> deleteBottomCategory(@PathVariable Long id) {

        ApiResponseDto topCategory = topCategoryService.deleteTopCategory(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(topCategory);
    }
}
