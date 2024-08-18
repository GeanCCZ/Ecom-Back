package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record BrandDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull(message = "'Display_name' must be informed")
    String displayName,

    String description,

    Image image,

    List<Product> productList
){}
