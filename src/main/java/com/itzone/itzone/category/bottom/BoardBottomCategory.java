package com.itzone.itzone.category.bottom;

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
@Table(name = "board_bottom_categories")
public class BoardBottomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_middle_category_id")
    private BoardMiddleCategory boardMiddleCategory;

    public BoardBottomCategory (String categoryName){
        this.categoryName = categoryName;
    }

}
