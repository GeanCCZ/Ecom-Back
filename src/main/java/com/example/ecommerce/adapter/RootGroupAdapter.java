package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.RootGroupDTO;
import com.example.ecommerce.domain.entities.RootGroup;

public class RootGroupAdapter implements Adapter<RootGroup, RootGroupDTO> {

    @Override
    public RootGroup fromDto(RootGroupDTO dto) {
        return new RootGroup(
                dto.display_name(),
                dto.sequence(),
                dto.image(),
                dto.productList(),
                dto.category()
        );
    }

    @Override
    public RootGroupDTO fromEntity(RootGroup entity) {
        return new RootGroupDTO(
                entity.getDisplayName(),
                entity.getSequence(),
                entity.getImage(),
                entity.getProductList(),
                entity.getCategory()
        );
    }
}
