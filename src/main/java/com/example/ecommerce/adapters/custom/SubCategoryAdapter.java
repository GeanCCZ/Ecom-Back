package com.example.ecommerce.adapters.custom;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.SubCategoryDTO;
import com.example.ecommerce.domain.entities.SubCategory;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryAdapter implements Adapter<SubCategory, SubCategoryDTO> {

    @Override
    public SubCategory fromDto(SubCategoryDTO dto) {
        return new SubCategory(
                dto.displayName(),
                dto.productList(),
                dto.category())
                ;
    }

    @Override
    public SubCategoryDTO fromEntity(SubCategory entity) {
        return new SubCategoryDTO(
                entity.getId(),
                entity.getDisplayName(),
                entity.getProductList(),
                entity.getCategory()
        );
    }
}
