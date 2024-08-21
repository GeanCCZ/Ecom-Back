package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.RootGroupDTO;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.RootGroup;
import org.springframework.stereotype.Service;

@Service
public class RootGroupAdapter implements Adapter<RootGroup, RootGroupDTO> {

    @Override
    public RootGroup fromDto(RootGroupDTO dto) {
        return new RootGroup(
                dto.displayName(),
                dto.sequence(),
                dto.image(),
                dto.productList(),
                dto.category()
        );
    }

    @Override
    public SupplierDTO fromEntity(RootGroup entity) {
        return new RootGroupDTO(
                entity.getId(),
                entity.getDisplayName(),
                entity.getSequence(),
                entity.getImage(),
                entity.getProductList(),
                entity.getCategory()
        );
    }
}
