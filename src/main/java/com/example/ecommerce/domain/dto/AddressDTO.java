package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.Supplier;
import com.example.ecommerce.domain.entities.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AddressDTO (

    @JsonInclude(JsonInclude.Include.NON_NULL)
    UUID id,

    @NotBlank(message = "'Street' must be informed")
    String street,

    @NotNull(message = "'Number' must be informed")
    String number,

    @NotNull(message = "'Cep' must be informed")
    String cep,

    @NotNull(message = "'City' must be informed")
    String city,

    @NotNull(message = "'State' must be informed")
    String state,

    @NotNull(message = "'Country' must be informed")
    String country,

    @NotNull(message = "'Complement' must be informed")
    String complement,

    @NotNull(message = "'Neighborhood' must be informed")
    String neighborhood,

    Supplier supplier,

    User user
){}

