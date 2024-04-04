package com.itzone.itzone.category.middle;

import com.itzone.itzone.category.bottom.BoardBottomCategory;
import com.itzone.itzone.category.top.BoardTopCategory;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "board_middle_categories")
public class BoardMiddleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private String categoryClassification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_top_category_id")
    private BoardTopCategory boardTopCategory;

    @Builder
    public BoardMiddleCategory(String categoryName, String categoryClassification, BoardTopCategory boardTopCategory) {
        this.categoryName = categoryName;
        this.categoryClassification = categoryClassification;
        this.boardTopCategory = boardTopCategory;
    }

    public BoardMiddleCategory update(String categoryName, String categoryClassification, BoardTopCategory boardTopCategory) {
        this.categoryName = categoryName;
        this.categoryClassification = categoryClassification;
        this.boardTopCategory = boardTopCategory;

        return this;
    }}
