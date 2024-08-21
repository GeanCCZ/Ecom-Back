package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.DiscountDTO;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Discount;
import org.springframework.stereotype.Service;

@Service
public class DiscountAdapter implements Adapter<Discount, DiscountDTO> {

    @Override
    public Discount fromDto(DiscountDTO dto) {
        return new Discount(dto.presentedValue(), dto.type(), dto.finalValue(), dto.productList());
    }

    @Override
    public SupplierDTO fromEntity(Discount entity) {
        return new DiscountDTO(entity.getId(),entity.getPresentedValue(),entity.getType(),entity.getFinalValue(),entity.getProductList());
    }

}
