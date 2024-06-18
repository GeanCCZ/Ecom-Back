package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.DiscountDTO;
import com.example.ecommerce.domain.entities.Discount;

public class DiscountAdapter implements Adapter<Discount, DiscountDTO> {

    @Override
    public Discount fromDto(DiscountDTO dto) {
        return new Discount(dto.presented_value(),dto.type(),dto.final_value(),dto.productList());
    };

    @Override
    public DiscountDTO fromEntity(Discount entity) {
        return new DiscountDTO(entity.getPresentedValue(),entity.getType(),entity.getFinalValue(),entity.getProductList());
    };

}
