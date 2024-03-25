package com.itzone.itzone.category;

import com.itzone.itzone.board.BoardRequestDto;
import com.itzone.itzone.category.bottom.BottomCategoryListResponseDto;
import com.itzone.itzone.category.bottom.BottomCategoryRequestDto;
import com.itzone.itzone.category.bottom.BottomCategoryResponseDto;
import com.itzone.itzone.category.bottom.BottomCategoryServiceImpl;
import com.itzone.itzone.category.middle.MiddleCategoryListResponseDto;
import com.itzone.itzone.category.middle.MiddleCategoryServiceImpl;
import com.itzone.itzone.category.top.TopCategoryListResponseDto;
import com.itzone.itzone.category.top.TopCategoryResponseDto;
import com.itzone.itzone.category.top.TopCategoryService;
import com.itzone.itzone.category.top.TopCategoryServiceImpl;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.Category;
import com.itzone.itzone.common.Category.Classtification;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final BottomCategoryServiceImpl bottomCategoryService;

    private final MiddleCategoryServiceImpl middleCategoryService;

    private final TopCategoryServiceImpl topCategoryService;

    private final CategoryService categoryService;


    //생성
    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto> createCategory(@ModelAttribute CategoryRequestDto requestDto) {

        ApiResponseDto result = categoryService.cretateCategory(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    //조회 Top Category
    @GetMapping("/categories/top")
    public ResponseEntity<TopCategoryListResponseDto> readTopCategory(){

        TopCategoryListResponseDto topCategory = topCategoryService.getTopCategory();

        return ResponseEntity.ok().body(topCategory);
    }

    //조회 Middle Category
    @GetMapping("/categories/middle")
    public ResponseEntity<MiddleCategoryListResponseDto> readMiddleCategory(){

        MiddleCategoryListResponseDto middleCategory = middleCategoryService.getMiddleCategory();

        return ResponseEntity.ok().body(middleCategory);
    }

    //조회 Bottom Category
    @GetMapping("/categories/bottom")
    public ResponseEntity<BottomCategoryListResponseDto> readBottomCategory(){

        BottomCategoryListResponseDto bottomCategory = bottomCategoryService.getBottomCategory();

        return ResponseEntity.ok().body(bottomCategory);
    }

    //수정
    @PutMapping("/category/{id}")
    public ResponseEntity<ApiResponseDto> updateBottomCategory(@PathVariable Long id, @RequestBody CategoryRequestDto categoryRequestDto) {

        ApiResponseDto updateCategory = categoryService.updateCategory(id, categoryRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(updateCategory);

    }

    //삭제
    @DeleteMapping("/topcategory/{id}")
    public ResponseEntity<ApiResponseDto> deleteTopCategory(@PathVariable Long id) {

        ApiResponseDto topCategory = topCategoryService.deleteTopCategory(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(topCategory);
    }


    //삭제
    @DeleteMapping("/middlecategory/{id}")
    public ResponseEntity<ApiResponseDto> deleteMiddleCategory(@PathVariable Long id) {

        ApiResponseDto middleCategory = middleCategoryService.deleteMiddleCategory(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(middleCategory);
    }

    //삭제
    @DeleteMapping("/bottomcategory/{id}")
    public ResponseEntity<ApiResponseDto> deleteBottomCategory(@PathVariable Long id) {

        ApiResponseDto bottomCategory = bottomCategoryService.deleteBottomCategory(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bottomCategory);

    }

}
