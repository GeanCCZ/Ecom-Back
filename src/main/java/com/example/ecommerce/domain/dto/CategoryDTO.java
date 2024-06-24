package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.SubCategory;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record CategoryDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull(message = "'Display_name' must be informed")
    String display_name,

    List<SubCategory> subCategoryList

){}
