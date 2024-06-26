package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.OrderDTO;
import com.example.ecommerce.domain.entities.Order;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController extends CRUDController<Order, UUID, OrderDTO> {

    public OrderController(CRUDService<Order, UUID, OrderDTO> service){
        super(service);
    }

}
