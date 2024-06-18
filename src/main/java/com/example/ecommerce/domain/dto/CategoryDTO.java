package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.SubCategory;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CategoryDTO(

    @NotNull(message = "'Display_name' must be informed")
    String display_name,

    List<SubCategory> subCategoryList
){}
