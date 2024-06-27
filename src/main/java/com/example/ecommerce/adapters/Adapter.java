package com.example.ecommerce.adapters;

public interface Adapter<T, DTO> {

    T fromDto(DTO dto);

    DTO fromEntity(T entity);

}
