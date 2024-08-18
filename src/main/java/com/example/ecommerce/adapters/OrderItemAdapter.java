package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.OrderItemDTO;
import com.example.ecommerce.domain.entities.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderItemAdapter implements Adapter<OrderItem, OrderItemDTO> {

    @Override
    public OrderItem fromDto(OrderItemDTO dto) {
        return new OrderItem(
                dto.product(),
                dto.order(),
                dto.quantity(),
                dto.totalPrice()
        );
    }

    @Override
    public OrderItemDTO fromEntity(OrderItem entity) {
        return new OrderItemDTO(
                entity.getId(),
                entity.getProduct(),
                entity.getOrder(),
                entity.getQuantity(),
                entity.getTotalPrice()
        );
    }
}
