package com.itzone.itzone.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMiddleCategoryRepository extends JpaRepository<BoardMiddleCategory, Long> {
}
