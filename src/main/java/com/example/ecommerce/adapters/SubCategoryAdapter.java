package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.SubCategoryDTO;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.SubCategory;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryAdapter implements Adapter<SubCategory, SubCategoryDTO> {

    @Override
    public SubCategory fromDto(SubCategoryDTO dto) {
        return new SubCategory(
                dto.displayName(),
                dto.productList()
        );
    }

    @Override
    public SupplierDTO fromEntity(SubCategory entity) {
        return new SubCategoryDTO(
                entity.getId(),
                entity.getDisplayName(),
                entity.getProductList()
        );
    }
}
