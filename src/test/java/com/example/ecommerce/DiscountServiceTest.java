package com.example.ecommerce;

import com.example.ecommerce.domain.dto.DiscountDTO;
import com.example.ecommerce.service.DiscountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class DiscountServiceTest {

    @InjectMocks
    private DiscountService discountService;

    @Test
    public void testDiscountCreate(){

        DiscountDTO newDiscount = new DiscountDTO(UUID.randomUUID(),15.0,1,0.15,null);


    }

}
