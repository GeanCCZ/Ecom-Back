package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Order;
import com.example.ecommerce.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record OrderItemDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull(message = "'Product' must be informed")
    Product product,

    @NotNull(message = "'Order' must be informed")
    Order order,

    @NotNull(message = "'Quantity' must be informed")
    int quantity,

    @NotNull(message = "'Total_price' must be informed")
    Double total_price
){}
