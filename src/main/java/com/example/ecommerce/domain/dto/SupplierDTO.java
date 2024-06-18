package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Address;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.domain.entities.Stock;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record SupplierDTO(
        @NotNull(message = "'Trade Name' must be informed")
        String trade_name,
        @NotNull(message = "'Legal Name' must be informed")
        String legal_name,
        @NotNull(message = "'Description' must be informed")
        String description,
        @NotNull(message = "'CNPJ' must be informed")
        String cnpj,
        List<Address> addressList,
        List<Stock> stockList,
        List<Product> productList
){}
