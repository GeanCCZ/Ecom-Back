package com.example.ecommerce.repository.custom;

import com.example.ecommerce.domain.entities.Order;
import com.example.ecommerce.repository.CRUDRepository;

import java.util.UUID;

public interface OrderRepository extends CRUDRepository<Order, UUID> {

}
