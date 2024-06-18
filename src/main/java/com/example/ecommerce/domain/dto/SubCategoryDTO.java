package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Category;
import com.example.ecommerce.domain.entities.Product;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record SubCategoryDTO(

        @NotNull(message = "'Display Name' must be informed")
        String display_name,

        Category category,

        List<Product> productList

){}
