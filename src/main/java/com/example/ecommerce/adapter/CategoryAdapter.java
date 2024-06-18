package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.CategoryDTO;
import com.example.ecommerce.domain.entities.Category;

public class CategoryAdapter implements Adapter<Category, CategoryDTO>{

    public Category fromDto(CategoryDTO dto) {
        return new Category(dto.display_name(),dto.subCategoryList());
    };

    public CategoryDTO fromEntity(Category entity) {
        return new CategoryDTO(entity.getDisplayName(),entity.getSubCategoryList());
    };

}
