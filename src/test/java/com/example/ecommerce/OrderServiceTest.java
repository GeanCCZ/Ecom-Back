package com.example.ecommerce;

import com.example.ecommerce.domain.dto.OrderDTO;
import com.example.ecommerce.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Test
    public void testOrderCreate(){

        OrderDTO newOrder = new OrderDTO(null, false,1, 1, true,new Date(),null,null);

        OrderDTO createdOrder = this.orderService.create(newOrder);

        assertEquals(newOrder.parcel(), createdOrder.parcel());
        assertEquals(newOrder.num_parcels(), createdOrder.num_parcels());
        assertEquals(newOrder.actual_parcel(), createdOrder.actual_parcel());
        assertEquals(newOrder.active(), createdOrder.active());
        assertEquals(newOrder.date(), createdOrder.date());
        assertEquals(newOrder.orderItems(), createdOrder.orderItems());
        assertEquals(newOrder.user(), createdOrder.user());

    }

    @Test
    public void testOrderUpdate(){

        OrderDTO newOrder = new OrderDTO(null, false,1, 1, true,new Date(),null,null);

        OrderDTO createdOrder = this.orderService.create(newOrder);

        OrderDTO updateOrderDTO = new OrderDTO(createdOrder.id(), true,12, 3, true,new Date(),null,null);

        OrderDTO updatedOrder = this.orderService.update(createdOrder.id(),updateOrderDTO);

        assertEquals(updateOrderDTO.parcel(), updatedOrder.parcel());
        assertEquals(updateOrderDTO.num_parcels(), updatedOrder.num_parcels());
        assertEquals(updateOrderDTO.actual_parcel(), updatedOrder.actual_parcel());
        assertEquals(updateOrderDTO.active(), updatedOrder.active());
        assertEquals(updateOrderDTO.date(), updatedOrder.date());
        assertEquals(updateOrderDTO.orderItems(), updatedOrder.orderItems());
        assertEquals(updateOrderDTO.user(), updatedOrder.user());

    }
}
