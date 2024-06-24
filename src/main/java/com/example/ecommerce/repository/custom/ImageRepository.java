package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.UUID;

public interface ImageRepository extends CRUDRepository<Image, UUID> {
}
