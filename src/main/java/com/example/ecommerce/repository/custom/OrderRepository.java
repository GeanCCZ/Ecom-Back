package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Order;
import com.example.ecommerce.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends CRUDRepository<Order, UUID> {
}
