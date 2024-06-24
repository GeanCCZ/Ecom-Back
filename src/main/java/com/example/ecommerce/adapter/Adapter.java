package com.example.ecommerce.adapter;

import org.springframework.stereotype.Service;

@Service
public interface Adapter<T, DTO> {

    T fromDto(DTO dto);

    DTO fromEntity(T entity);

}
