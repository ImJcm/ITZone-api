package com.itzone.itzone.category;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@RequiredArgsConstructor
public class BoardTopService {

    private BoardTopCategoryRepository boardTopCategoryRepository;

    private BoardMiddleCategoryRepository boardMiddleCategoryRepository;

    private BoardBottomCategoryRepository boardBottomCategoryRepository;



}
