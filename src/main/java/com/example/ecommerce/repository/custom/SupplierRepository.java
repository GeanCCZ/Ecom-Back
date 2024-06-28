package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Supplier;
import com.example.ecommerce.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SupplierRepository extends CRUDRepository<Supplier, UUID> {

    Optional<Supplier> findByLegalName(String legalName);

    Optional<Supplier> findByTradeName(String tradeName);

}
