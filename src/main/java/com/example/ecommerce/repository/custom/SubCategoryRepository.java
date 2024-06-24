package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.SubCategory;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.UUID;

public interface SubCategoryRepository extends CRUDRepository<SubCategory, UUID> {
}
