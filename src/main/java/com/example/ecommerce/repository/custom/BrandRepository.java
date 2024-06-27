package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrandRepository extends CRUDRepository<Brand, UUID> {

    Optional<Brand> findByDisplayName(String name);

}
