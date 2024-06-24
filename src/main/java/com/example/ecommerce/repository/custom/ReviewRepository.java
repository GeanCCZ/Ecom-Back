package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Review;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.UUID;

public interface ReviewRepository extends CRUDRepository<Review, UUID> {
}
