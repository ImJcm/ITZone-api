package com.itzone.itzone.category.bottom;

import com.itzone.itzone.category.CategoryRequestDto;
import com.itzone.itzone.common.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BottomCategoryController {

    private final BottomCategoryServiceImpl bottomCategoryService;
    //생성
    @PostMapping("/admin/categories/bottom")
    public ResponseEntity<ApiResponseDto> createCategory(@ModelAttribute BottomCategoryRequestDto bottomCategoryRequestDto) {

        ApiResponseDto result = bottomCategoryService.createBottomCategory(bottomCategoryRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //조회 Bottom Category
    @GetMapping("/categories/bottom")
    public ResponseEntity<BottomCategoryListResponseDto> readBottomCategory(){

        BottomCategoryListResponseDto bottomCategory = bottomCategoryService.getBottomCategory();

        return ResponseEntity.ok().body(bottomCategory);
    }

    //수정
    @PutMapping("/admin/categories/bottom/{id}")
    public ResponseEntity<ApiResponseDto> updateBottomCategory(@PathVariable Long id, @RequestBody BottomCategoryRequestDto bottomCategoryRequestDto) {

        ApiResponseDto updateCategory = bottomCategoryService.updateBottomCategory(id, bottomCategoryRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(updateCategory);

    }

    //삭제
    @DeleteMapping("/admin/categories/bottom/{id}")
    public ResponseEntity<ApiResponseDto> deleteBottomCategory(@PathVariable Long id) {

        ApiResponseDto bottomCategory = bottomCategoryService.deleteBottomCategory(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bottomCategory);

    }
}
