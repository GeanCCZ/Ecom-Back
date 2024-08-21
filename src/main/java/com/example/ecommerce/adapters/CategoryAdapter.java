package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.CategoryDTO;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryAdapter implements Adapter<Category, CategoryDTO>{

    public Category fromDto(CategoryDTO dto) {
        return new Category(dto.displayName(), dto.productList());
    }

    public SupplierDTO fromEntity(Category entity) {
        return new CategoryDTO(entity.getId(),entity.getDisplayName(),entity.getProductList());
    }

}
