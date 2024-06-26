package com.example.ecommerce.adapters;

import org.springframework.stereotype.Service;

public interface Adapter<T, DTO> {

    T fromDto(DTO dto);

    DTO fromEntity(T entity);

}
