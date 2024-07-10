package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.CategoryDTO;
import com.example.ecommerce.domain.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryAdapter implements Adapter<Category, CategoryDTO>{

    public Category fromDto(CategoryDTO dto) {
        return new Category(dto.display_name(),dto.productList());
    }

    public CategoryDTO fromEntity(Category entity) {
        return new CategoryDTO(entity.getId(),entity.getDisplayName(),entity.getProductList());
    }

}
