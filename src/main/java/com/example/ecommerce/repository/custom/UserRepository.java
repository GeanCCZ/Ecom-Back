package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.User;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.UUID;

public interface UserRepository extends CRUDRepository<User, UUID> {
}
