package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Stock;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.UUID;

public interface StockRepository extends CRUDRepository<Stock, UUID> {
}
