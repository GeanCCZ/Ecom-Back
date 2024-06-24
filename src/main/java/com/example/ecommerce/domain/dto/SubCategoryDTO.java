package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Category;
import com.example.ecommerce.domain.entities.Product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public record SubCategoryDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull(message = "'Display Name' must be informed")
    String display_name,

    Category category,

    List<Product> productList

){}
