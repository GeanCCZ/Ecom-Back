package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.StockDTO;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Stock;
import org.springframework.stereotype.Service;

@Service
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
                entity.getId(),
                entity.getQuantity(),
                entity.getSupplier(),
                entity.getProduct()
        );
    }
}
