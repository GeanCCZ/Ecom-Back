package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Product;
import jakarta.validation.constraints.NotNull;

import java.util.List;


public record DiscountDTO(

    @NotNull(message = "'Presented_value' must be informed")
    Double presented_value,

    @NotNull(message = "'Type' must be informed")
    Number type,

    @NotNull(message = "'Final_value' must be informed")
    Double final_value,

    List<Product> productList
){}
