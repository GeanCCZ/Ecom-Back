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

        DiscountDTO expectedDiscount = new DiscountDTO(createdDiscount.id(), newDiscount.presentedValue(), newDiscount.type(), newDiscount.finalValue(), newDiscount.productList());

        assertEquals(newDiscount.type(), expectedDiscount.type());
        assertEquals(newDiscount.presentedValue(), expectedDiscount.presentedValue());
        assertEquals(newDiscount.finalValue(), expectedDiscount.finalValue());
        assertEquals(newDiscount.productList(), expectedDiscount.productList());
    }

    @Test
    public void testDiscountUpdate(){

        DiscountDTO newDiscount = new DiscountDTO(null,15.0,1,0.15,null);

        DiscountDTO createdDiscount = this.discountService.create(newDiscount);

        DiscountDTO updatedDiscountDTO = new DiscountDTO(createdDiscount.id(),75.33,1,0.35,null);

        DiscountDTO updatedDiscount = this.discountService.update(createdDiscount.id(),updatedDiscountDTO);

        assertEquals(updatedDiscountDTO.type(), updatedDiscount.type());
        assertEquals(updatedDiscountDTO.presentedValue(), updatedDiscount.presentedValue());
        assertEquals(updatedDiscountDTO.finalValue(), updatedDiscount.finalValue());
        assertEquals(updatedDiscountDTO.productList(), updatedDiscount.productList());

    }

}
