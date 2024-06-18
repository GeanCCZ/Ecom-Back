package com.example.ecommerce.adapter;

public interface Adapter<T, DTO> {

    T fromDto(DTO dto);

    DTO fromEntity(T entity);

}
