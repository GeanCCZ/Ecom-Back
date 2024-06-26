package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.OrderDTO;
import com.example.ecommerce.domain.entities.OrderItem;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("orderItem")
public class OrderItemController extends CRUDController<OrderItem, UUID, OrderDTO> {

    public OrderItemController(CRUDService<OrderItem, UUID, OrderDTO> service){
        super(service);
    }

}
