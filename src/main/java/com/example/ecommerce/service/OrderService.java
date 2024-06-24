package com.example.ecommerce.service;

import com.example.ecommerce.adapter.Adapter;
import com.example.ecommerce.domain.dto.OrderDTO;
import com.example.ecommerce.domain.entities.Order;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService extends CRUDService<Order, UUID, OrderDTO>{

    private final OrderRepository orderRepository;

    public OrderService(CRUDRepository<Order,UUID> repository, Adapter<Order, OrderDTO> adapter, OrderRepository orderRepository){
        super(repository,adapter);
        this.orderRepository = orderRepository;
    }

    @Override
    protected void checkSave(OrderDTO dto, Order entity){
        boolean alreadyExists = this.orderRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

}
