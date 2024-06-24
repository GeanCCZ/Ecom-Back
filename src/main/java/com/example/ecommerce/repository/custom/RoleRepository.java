package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Role;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.UUID;

public interface RoleRepository extends CRUDRepository<Role, UUID> {
}
