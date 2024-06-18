package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.StockDTO;
import com.example.ecommerce.domain.entities.Stock;

public class StockAdapter implements Adapter<Stock, StockDTO> {

    @Override
    public Stock fromDto(StockDTO dto) {
        return new Stock(
                dto.quantity(),
                dto.supplier(),
                dto.product()
        );
    }

    @Override
    public StockDTO fromEntity(Stock entity) {
        return new StockDTO(
                entity.getQuantity(),
                entity.getSupplier(),
                entity.getProduct()
        );
    }
}
