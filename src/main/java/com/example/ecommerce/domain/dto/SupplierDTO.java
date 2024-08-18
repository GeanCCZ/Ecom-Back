package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Address;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.domain.entities.Stock;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public record SupplierDTO(

        @JsonInclude(JsonInclude.Include.NON_NULL)
        UUID id,

        @NotNull(message = "'Trade Name' must be informed")
        String tradeName,

        @NotNull(message = "'Legal Name' must be informed")
        String legalName,

        @NotNull(message = "'Description' must be informed")
        String description,

        @NotNull(message = "'CNPJ' must be informed")
        String cnpj,

        List<Address> addressList,

        List<Stock> stockList,

        List<Product> productList
){}
