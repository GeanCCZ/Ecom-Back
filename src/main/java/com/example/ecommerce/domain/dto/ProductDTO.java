package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.domain.entities.Category;
import com.example.ecommerce.domain.entities.Discount;
import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.domain.entities.Review;
import com.example.ecommerce.domain.entities.Stock;
import com.example.ecommerce.domain.entities.SubCategory;
import com.example.ecommerce.domain.entities.Supplier;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record ProductDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull(message = "'Display_name' must be informed")
    String display_name,

    @NotNull(message = "'Description' must be informed")
    String description,

    @NotNull(message = "'Price' must be informed")
    Double price,

    String applicable_discount,

    @NotNull(message = "'Stock' must be informed")
    List<Stock> stockList,

    Discount discount,

    @NotNull(message = "'Category' must be informed")
    Category category,

    List<SubCategory> subCategoryList,

    @NotNull(message = "'Brand' must be informed")
    Brand brand,

    List<Review> reviewList,

    @NotNull(message = "'Supplier' must be informed")
    Supplier supplier

){}
