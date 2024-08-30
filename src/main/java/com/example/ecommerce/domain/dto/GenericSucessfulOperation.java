package com.example.ecommerce.domain.dto;

import jakarta.annotation.Nullable;

public record GenericSucessfulOperation<T>(

        @Nullable
        T responseData,

        String message

) {
}
