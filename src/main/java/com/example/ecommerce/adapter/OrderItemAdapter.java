package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.OrderItemDTO;
import com.example.ecommerce.domain.entities.OrderItem;

public class OrderItemAdapter implements Adapter<OrderItem, OrderItemDTO> {

    @Override
    public OrderItem fromDto(OrderItemDTO dto) {
        return new OrderItem(
                dto.product(),
                dto.order(),
                dto.quantity(),
                dto.total_price()
        );
    }

    @Override
    public OrderItemDTO fromEntity(OrderItem entity) {
        return new OrderItemDTO(
                entity.getProduct(),
                entity.getOrder(),
                entity.getQuantity(),
                entity.getTotalPrice()
        );
    }
}
