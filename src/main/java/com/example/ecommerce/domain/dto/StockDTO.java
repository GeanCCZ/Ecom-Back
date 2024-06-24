package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.domain.entities.Supplier;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record StockDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull
    Integer quantity,

    @NotNull
    Supplier supplier,

    @NotNull
    Product product

) {}
