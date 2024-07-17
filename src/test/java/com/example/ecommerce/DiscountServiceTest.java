package com.example.ecommerce;

import com.example.ecommerce.domain.dto.DiscountDTO;
import com.example.ecommerce.service.DiscountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DiscountServiceTest {

    @Autowired
    private DiscountService discountService;

    @Test
    public void testDiscountCreate(){

        DiscountDTO newDiscount = new DiscountDTO(null,15.0,1,0.15,null);

        DiscountDTO createdDiscount = this.discountService.create(newDiscount);

        DiscountDTO expectedDiscount = new DiscountDTO(createdDiscount.id(),newDiscount.presented_value(),newDiscount.type(),newDiscount.final_value(),newDiscount.productList());

        assertEquals(expectedDiscount,createdDiscount);
    }

    @Test
    public void testDiscountUpdate(){

        DiscountDTO newDiscount = new DiscountDTO(null,15.0,1,0.15,null);

        DiscountDTO createdDiscount = this.discountService.create(newDiscount);

        DiscountDTO updatedDiscountDTO = new DiscountDTO(createdDiscount.id(),75.33,1,0.35,null);

        DiscountDTO updatedDiscount = this.discountService.update(createdDiscount.id(),updatedDiscountDTO);

        DiscountDTO expectedDiscount = new DiscountDTO(updatedDiscount.id(), updatedDiscountDTO.presented_value(), updatedDiscountDTO.type(), updatedDiscountDTO.final_value(), updatedDiscountDTO.productList());

        assertEquals(updatedDiscount, expectedDiscount);

    }

}
