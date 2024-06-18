package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.OrderDTO;
import com.example.ecommerce.domain.entities.Order;

public class OrderAdapter implements Adapter<Order, OrderDTO> {

    @Override
    public Order fromDto(OrderDTO dto) {
        return new Order(
                dto.parcel(),
                dto.num_parcels(),
                dto.actual_parcel(),
                dto.active(),
                dto.date(),
                dto.orderItems(),
                dto.user()
        );
    }

    @Override
    public OrderDTO fromEntity(Order entity) {
        return new OrderDTO(
                entity.isParcel(),
                entity.getNumParcels(),
                entity.getActualParcel(),
                entity.isActive(),
                entity.getDate(),
                entity.getOrderItems(),
                entity.getUser()
        );
    }
}
