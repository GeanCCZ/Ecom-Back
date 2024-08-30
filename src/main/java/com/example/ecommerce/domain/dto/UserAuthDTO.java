package com.example.ecommerce.domain.dto;

import jakarta.validation.constraints.NotNull;

public record UserAuthDTO(

        @NotNull(message = "'Email' must be informed")
        String email,

        @NotNull(message = "'Password' must be informed")
        String password

) {
}
