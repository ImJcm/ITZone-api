package com.itzone.itzone.category;

import com.itzone.itzone.board.Board;
import com.itzone.itzone.category.bottom.BoardBottomCategory;
import com.itzone.itzone.category.bottom.BoardBottomCategoryRepository;
import com.itzone.itzone.category.middle.BoardMiddleCategory;
import com.itzone.itzone.category.middle.BoardMiddleCategoryRepository;
import com.itzone.itzone.category.top.BoardTopCategory;
import com.itzone.itzone.category.top.BoardTopCategory.BoardTopCategoryBuilder;
import com.itzone.itzone.category.top.BoardTopCategoryRepository;
import com.itzone.itzone.category.top.TopCategoryListResponseDto;
import com.itzone.itzone.category.top.TopCategoryResponseDto;
import com.itzone.itzone.common.ApiResponseDto;
import com.itzone.itzone.common.Category;
import com.itzone.itzone.common.ErrorCode;
import com.itzone.itzone.common.ItzoneException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService{

    private BoardTopCategoryRepository boardTopCategoryRepository;

    private BoardMiddleCategoryRepository boardMiddleCategoryRepository;

    private BoardBottomCategoryRepository boardBottomCategoryRepository;


    /**
     *  카테고리 생성
     * @param categoryRequestDto
     * @return
     */
    @Transactional
    @Override
    public ApiResponseDto cretateCategory(CategoryRequestDto categoryRequestDto) {

        if(categoryRequestDto.getCategoryClassification() == Category.Classtification.Top){
            BoardTopCategory boardTopCategory = BoardTopCategory.builder()
                    .categoryName(categoryRequestDto.getCategoryName())
                    .build();

            boardTopCategoryRepository.save(boardTopCategory);

        }else if(categoryRequestDto.getCategoryClassification() == Category.Classtification.Middle){

            BoardMiddleCategory boardMiddleCategory = BoardMiddleCategory.builder()
                    .categoryName(categoryRequestDto.getCategoryName())
                    .classificationSub(categoryRequestDto.getClassificationSub())
                    .build();

            boardMiddleCategoryRepository.save(boardMiddleCategory);
        }else if(categoryRequestDto.getCategoryClassification() == Category.Classtification.Bottom){

            BoardBottomCategory boardBottomCategory = BoardBottomCategory.builder()
                    .categoryName(categoryRequestDto.getCategoryName())
                    .classificationSub(categoryRequestDto.getClassificationSub())
                    .build();

            boardBottomCategoryRepository.save(boardBottomCategory);

        }else{
            new ItzoneException(ErrorCode.CREATE_ERROR);
        }

        return new ApiResponseDto("카테고리리 등록 성공", HttpStatus.CREATED.value());
    }


    @Override
    public ApiResponseDto updateCategory(Long id, CategoryRequestDto categoryRequestDto) {

        if(categoryRequestDto.getCategoryClassification() == Category.Classtification.Top){
            BoardTopCategory boardTopCategory = boardTopCategoryRepository.findById(id).orElseThrow();

            boardTopCategory.setCategoryName(categoryRequestDto.getCategoryName());
            boardTopCategory.setClassification(categoryRequestDto.getCategoryClassification());


        }else if(categoryRequestDto.getCategoryClassification() == Category.Classtification.Middle){
            BoardMiddleCategory boardMiddleCategory = boardMiddleCategoryRepository.findById(id).orElseThrow();

            boardMiddleCategory.setCategoryName(categoryRequestDto.getCategoryName());
            boardMiddleCategory.setClassificationSub(categoryRequestDto.getCategoryClassification());

        }else if(categoryRequestDto.getCategoryClassification() == Category.Classtification.Bottom){
            BoardBottomCategory boardBottomCategory = boardBottomCategoryRepository.findById(id).orElseThrow();

            boardBottomCategory.setCategoryName(categoryRequestDto.getCategoryName());
            boardBottomCategory.setClassificationSub(categoryRequestDto.getClassificationSub());

        }else{
            new ItzoneException(ErrorCode.UPDATE_ERROR);
        }
        return new ApiResponseDto("카테고리 수정 성공", HttpStatus.CREATED.value());
    }

    @Override
    public ApiResponseDto deleteCategory(Long id) {
        return null;
    }
}
