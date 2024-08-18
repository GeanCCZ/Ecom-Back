package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Address;
import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.domain.entities.Order;
import com.example.ecommerce.domain.entities.Review;
import com.example.ecommerce.domain.entities.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record UserDTO(

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotNull(message = "'Address' must be informed")
    List<Address> addressList,

    @NotNull(message = "'Role' must be informed")
    Role role,

    Image image,

    List<Order> orders,

    List<Review> reviewList,

    @NotNull(message = "'First_name' must be informed")
    String firstName,

    @NotNull(message = "'Last_name' must be informed")
    String lastName,

    @NotNull(message = "'Email' must be informed")
    String email,

    @NotNull(message = "'Phone' must be informed")
    String phone,

    @NotNull(message = "'Password' must be informed")
    String password

) {}
