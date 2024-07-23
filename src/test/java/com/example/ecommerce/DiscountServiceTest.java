package com.example.ecommerce;

import com.example.ecommerce.domain.dto.DiscountDTO;
import com.example.ecommerce.service.DiscountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DiscountServiceTest {

    @InjectMocks
    private DiscountService discountService;

    @Test
    public void testDiscountCreate(){

        DiscountDTO newDiscount = new DiscountDTO(null,15.0,1,0.15,null);

        DiscountDTO createdDiscount = this.discountService.create(newDiscount);

        DiscountDTO expectedDiscount = new DiscountDTO(createdDiscount.id(),newDiscount.presented_value(),newDiscount.type(),newDiscount.final_value(),newDiscount.productList());

        assertEquals(newDiscount.type(), expectedDiscount.type());
        assertEquals(newDiscount.presented_value(), expectedDiscount.presented_value());
        assertEquals(newDiscount.final_value(), expectedDiscount.final_value());
        assertEquals(newDiscount.productList(), expectedDiscount.productList());
    }

    @Test
    public void testDiscountUpdate(){

        DiscountDTO newDiscount = new DiscountDTO(null,15.0,1,0.15,null);

        DiscountDTO createdDiscount = this.discountService.create(newDiscount);

        DiscountDTO updatedDiscountDTO = new DiscountDTO(createdDiscount.id(),75.33,1,0.35,null);

        DiscountDTO updatedDiscount = this.discountService.update(createdDiscount.id(),updatedDiscountDTO);

        assertEquals(updatedDiscountDTO.type(), updatedDiscount.type());
        assertEquals(updatedDiscountDTO.presented_value(), updatedDiscount.presented_value());
        assertEquals(updatedDiscountDTO.final_value(), updatedDiscount.final_value());
        assertEquals(updatedDiscountDTO.productList(), updatedDiscount.productList());

    }

}
