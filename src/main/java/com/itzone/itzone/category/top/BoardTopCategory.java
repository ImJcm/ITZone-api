package com.itzone.itzone.category.top;

import com.itzone.itzone.category.middle.BoardMiddleCategory;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "board_top_categories")
public class BoardTopCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private String categoryClassification;

    @Builder
    public BoardTopCategory(String categoryName, String categoryClassification) {
        this.categoryName = categoryName;
        this.categoryClassification = categoryClassification;
    }

    public BoardTopCategory update(String categoryName, String categoryClassification) {
        this.categoryName = categoryName;
        this.categoryClassification = categoryClassification;

        return this;
    }
}
