package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record BrandDTO(

    @NotNull(message = "'Display_name' must be informed")
    String display_name,

    String description,

    Image image,

    List<Product> productList
){}
