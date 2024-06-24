package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.OrderItem;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.UUID;

public interface OrderItemRepository extends CRUDRepository<OrderItem, UUID> {
}
