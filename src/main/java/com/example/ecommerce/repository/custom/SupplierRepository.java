package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Supplier;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.UUID;

public interface SupplierRepository extends CRUDRepository<Supplier, UUID> {
}
