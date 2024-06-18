package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.domain.entities.RootGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.io.File;
import java.net.URL;
import java.util.UUID;

public record ImageDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull(message = "'public_id' must be informed")
    String public_id,

    @NotNull(message = "'Source' must be informed")
    String source,

    @NotNull(message = "'Alt' must be informed")
    String alt,

    @NotNull(message = "'Url' must be informed")
    String url,

    @NotNull(message = "'Sequence' must be informed")
    Integer sequence,

    File image_file,

    Brand brand,

    Product product,

    RootGroup rootGroup
){}
