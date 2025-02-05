package com.example.sales.dto;

import com.example.sales.entities.CustomerCategory;
import lombok.Getter;

@Getter
public class CustomerCategoryDTO {
    private Long categoryId;
    private String categoryName;

    public CustomerCategoryDTO(CustomerCategory category) {
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
    }
}
