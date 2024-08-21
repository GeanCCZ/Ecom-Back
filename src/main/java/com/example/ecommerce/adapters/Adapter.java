package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.SupplierDTO;
import org.springframework.stereotype.Service;

@Service
public interface Adapter<T, DTO> {

    T fromDto(DTO dto);

    SupplierDTO fromEntity(T entity);

}
