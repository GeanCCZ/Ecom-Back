package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.SubCategoryDTO;
import com.example.ecommerce.domain.entities.SubCategory;

public class SubCategoryAdapter implements Adapter<SubCategory, SubCategoryDTO> {

    @Override
    public SubCategory fromDto(SubCategoryDTO dto) {
        return new SubCategory(
                dto.display_name(),
                dto.category(),
                dto.productList()
        );
    }

    @Override
    public SubCategoryDTO fromEntity(SubCategory entity) {
        return new SubCategoryDTO(
                entity.getDisplayName(),
                entity.getCategory(),
                entity.getProductList()
        );
    }
}
