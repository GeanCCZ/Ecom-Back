package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.BrandDTO;
import com.example.ecommerce.domain.entities.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandAdapter implements Adapter<Brand, BrandDTO> {

    @Override
    public Brand fromDto(BrandDTO dto) {
        return new Brand(dto.display_name(),dto.description(),dto.image(),dto.productList());
    }

    @Override
    public BrandDTO fromEntity(Brand entity) {
        return new BrandDTO(entity.getDisplay_name(), entity.getDisplay_name(), entity.getImage(), entity.getProductList());
    };

}
