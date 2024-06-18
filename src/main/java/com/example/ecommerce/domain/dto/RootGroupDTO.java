package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Category;
import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record RootGroupDTO(

    @NotNull(message = "'Display_name' must be informed")
    String display_name,

    @NotNull(message = "'Sequence' must be informed")
    Integer sequence,

    @NotNull(message = "'Image' must be informed")
    Image image,

    @NotNull(message = "'Product' must be informed")
    List<Product> productList,

    @NotNull(message = "'Category' must be informed")
    Category category
) {}
