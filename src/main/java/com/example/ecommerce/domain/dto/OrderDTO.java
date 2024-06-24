package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.OrderItem;
import com.example.ecommerce.domain.entities.User;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record OrderDTO(

        @JsonInclude(JsonInclude.Include.NON_NULL)
        UUID id,
        @NotNull(message = "'Parcel' must be informed")
        boolean parcel,

        @NotNull(message = "'Num Parcels' must be informed")
        Integer num_parcels,

        @NotNull(message = "'Actual Parcel' must be informed")
        Integer actual_parcel,

        @NotNull(message = "'Active' must be informed")
        boolean active,

        @NotNull(message = "'Date' must be informed")
        Date date,

        List<OrderItem> orderItems,

        User user
){}
