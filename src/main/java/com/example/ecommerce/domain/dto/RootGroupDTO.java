package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Category;
import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record RootGroupDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull(message = "'Display_name' must be informed")
    String displayName,

    @NotNull(message = "'Sequence' must be informed")
    Integer sequence,

    @NotNull(message = "'Image' must be informed")
    Image image,

    @NotNull(message = "'Product' must be informed")
    List<Product> productList,

    @NotNull(message = "'Category' must be informed")
    Category category
) {}
