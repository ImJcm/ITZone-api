package com.itzone.itzone.category.middle;

import com.itzone.itzone.category.bottom.BottomCategoryListResponseDto;
import com.itzone.itzone.category.bottom.BottomCategoryRequestDto;
import com.itzone.itzone.category.bottom.BottomCategoryResponseDto;
import com.itzone.itzone.category.bottom.BottomCategoryServiceImpl;
import com.itzone.itzone.common.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MiddleCategoryController {

    private final MiddleCategoryServiceImpl middleCategoryService;
    //생성
    @PostMapping("/admin/categories/middle")
    public ResponseEntity<ApiResponseDto> createCategory(@ModelAttribute MiddleCategoryRequestDto middleCategoryRequestDto) {

        ApiResponseDto result = middleCategoryService.createMiddleCategory(middleCategoryRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //조회
    @GetMapping("/categories/middle")
    public ResponseEntity<MiddleCategoryListResponseDto> readCategory(){

        MiddleCategoryListResponseDto middleCategory = middleCategoryService.getMiddleCategory();

        return ResponseEntity.status(HttpStatus.OK).body(middleCategory);
    }

    //수정
    @PutMapping("/admin/categories/middle/{id}")
    public ResponseEntity<MiddleCategoryResponseDto> updateMiddleCategory(@PathVariable Long id, @RequestBody MiddleCategoryRequestDto middleCategoryRequestDto) {

        MiddleCategoryResponseDto middleCategory = middleCategoryService.updateMiddleCategory(id, middleCategoryRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(middleCategory);
    }

    //삭제
    @DeleteMapping("/admin/categories/middle/{id}")
    public ResponseEntity<ApiResponseDto> deleteBottomCategory(@PathVariable Long id) {

        ApiResponseDto middleCategory = middleCategoryService.deleteMiddleCategory(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(middleCategory);
    }
}
