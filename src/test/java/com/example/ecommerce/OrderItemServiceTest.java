package com.example.ecommerce;

import com.example.ecommerce.domain.dto.OrderItemDTO;
import com.example.ecommerce.service.OrderItemService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderItemServiceTest {

    @InjectMocks
    private OrderItemService orderItemService;

    @Test
    public void testOrderItemCreate() {
        OrderItemDTO newOrderItem = new OrderItemDTO(null, null, null, 1, 10.56);

        OrderItemDTO createdOrderItem = this.orderItemService.create(newOrderItem);

        assertEquals(newOrderItem.product(), createdOrderItem.product());
        assertEquals(newOrderItem.quantity(), createdOrderItem.quantity());
        assertEquals(newOrderItem.totalPrice(), createdOrderItem.totalPrice());
    }

    @Test
    public void testOrderItemUpdate() {

        OrderItemDTO newOrderItem = new OrderItemDTO(null, null, null, 1, 10.56);

        OrderItemDTO createdOrderItem = this.orderItemService.create(newOrderItem);

        OrderItemDTO updateOrderItemDTO = new OrderItemDTO(createdOrderItem.id(), null, null, 1, 10.56);

        OrderItemDTO updatedOrderItem = this.orderItemService.update(newOrderItem.id(), updateOrderItemDTO);

        assertEquals(updateOrderItemDTO.product(), updatedOrderItem.product());
        assertEquals(updateOrderItemDTO.quantity(), updatedOrderItem.quantity());
        assertEquals(updateOrderItemDTO.totalPrice(), updatedOrderItem.totalPrice());
    }

}
