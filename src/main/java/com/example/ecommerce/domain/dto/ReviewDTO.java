package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.domain.entities.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record ReviewDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull(message = "'Avaliation_value' must be informed")
    Integer avaliationValue,

    @NotNull(message = "'Comment' must be informed")
    String comment,

    @NotNull(message = "'Date' must be informed")
    Date date,

    @NotNull(message = "'Product' must be informed")
    Product product,

    @NotNull(message = "'User' must be informed")
    User user
){}
