package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.OrderItemDTO;
import com.example.ecommerce.domain.entities.OrderItem;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderItemService extends CRUDService<OrderItem, UUID, OrderItemDTO> {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(CRUDRepository<OrderItem,UUID> repository, Adapter<OrderItem, OrderItemDTO> adapter, OrderItemRepository orderItemRepository){
        super(repository,adapter);
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    protected void checkSave(OrderItemDTO dto, OrderItem entity){
        boolean alreadyExists = this.orderItemRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

}
