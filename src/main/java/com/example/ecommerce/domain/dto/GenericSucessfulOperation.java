package com.example.ecommerce.domain.dto;

public record GenericSucessfulOperation<T>(

        T responseData,

        String message

) {
}
