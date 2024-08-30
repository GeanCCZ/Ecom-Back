package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.User;
import com.example.ecommerce.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CRUDRepository<User, UUID> {

    Optional<User> findByEmail(String email);

}
