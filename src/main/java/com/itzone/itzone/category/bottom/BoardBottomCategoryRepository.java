package com.itzone.itzone.category.bottom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardBottomCategoryRepository extends JpaRepository<BoardBottomCategory, Long> {
    Optional<BoardBottomCategory> findByCategoryName(String categoryName);
}
