package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends CRUDRepository<Product, UUID> {

    Optional<Product> findByDisplayName(String name);

}
