package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.Optional;
import java.util.UUID;

public interface BrandRepository extends CRUDRepository<Brand, UUID> {

    Optional<Brand> findByDisplayName(String name);

}
