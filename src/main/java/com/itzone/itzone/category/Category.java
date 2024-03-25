package com.itzone.itzone.category;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoryId;

    @Column(nullable = false)
    private String categoryName;

//    @OneToMany(mappedBy = "category", orphanRemoval = true)
//    private List<MiddleCategory> middleCategories;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}