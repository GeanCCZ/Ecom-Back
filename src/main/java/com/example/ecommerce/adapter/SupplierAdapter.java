package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Supplier;

public class SupplierAdapter implements Adapter<Supplier, SupplierDTO> {

    @Override
    public Supplier fromDto(SupplierDTO dto) {
        return new Supplier(
                dto.trade_name(),
                dto.legal_name(),
                dto.description(),
                dto.cnpj(),
                dto.addressList(),
                dto.stockList(),
                dto.productList()
        );
    }

    @Override
    public SupplierDTO fromEntity(Supplier entity) {
        return new SupplierDTO(

                entity.getTradeName(),

                entity.getLegalName(),

                entity.getDescription(),

                entity.getCnpj(),

                entity.getAddressList(),

                entity.getStockList(),

                entity.getProductList()

        );
    }
}
