package com.itzone.itzone.category.middle;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_top_category_id")
    private BoardTopCategory boardTopCategory;

    public BoardMiddleCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}
