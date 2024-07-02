package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.SubCategory;
import com.example.ecommerce.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubCategoryRepository extends CRUDRepository<SubCategory, UUID> {

    Optional<SubCategory> findByDisplayName(String displayName);
}
