package com.itzone.itzone.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardTopCategoryRepository extends JpaRepository<BoardTopCategory, Long> {
}
