package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.OrderDTO;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderAdapter implements Adapter<Order, OrderDTO> {

    @Override
    public Order fromDto(OrderDTO dto) {
        return new Order(
                dto.parcel(),
                dto.numParcels(),
                dto.actualParcel(),
                dto.active(),
                dto.date(),
                dto.orderItems(),
                dto.user()
        );
    }

    @Override
    public SupplierDTO fromEntity(Order entity) {
        return new OrderDTO(
                entity.getId(),
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
