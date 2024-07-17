package com.example.ecommerce;

import com.example.ecommerce.domain.dto.BrandDTO;
import com.example.ecommerce.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BrandServiceTest {

    @Autowired
    private BrandService brandService;

    @Test
    public void testBrandCreate(){

        BrandDTO newBrand = new BrandDTO(null,"Guugle","A new way to search your thoughts",null,null);

        BrandDTO createdBrand = this.brandService.create(newBrand);

        BrandDTO expectedBrand = new BrandDTO(createdBrand.id(),newBrand.display_name(),newBrand.description(),newBrand.image(),newBrand.productList());

        assertEquals(createdBrand,expectedBrand);
    }

}