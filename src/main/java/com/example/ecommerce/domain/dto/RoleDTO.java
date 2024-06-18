package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.User;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record RoleDTO(

        @NotNull(message = "'Display Name' must be informed")
        String display_name,

        List<User> user

){}
