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

        assertEquals(newBrand.description(), createdBrand.description());
        assertEquals(newBrand.image(), createdBrand.image());
        assertEquals(newBrand.productList(), createdBrand.productList());
        assertEquals(newBrand.display_name(), createdBrand.display_name());
    }

    @Test
    public void testBrandUpdate(){

        BrandDTO newBrand = new BrandDTO(null,"Guugle","A new way to search your thoughts",null,null);

        BrandDTO createdBrand = this.brandService.create(newBrand);

        BrandDTO updateBrandDTO = new BrandDTO(createdBrand.id(),"Amazonas Delivery", "A big big",null,null);

        BrandDTO updatedBrand = this.brandService.update(createdBrand.id(), updateBrandDTO);

        assertEquals(newBrand.description(), updatedBrand.description());
        assertEquals(newBrand.image(), updatedBrand.image());
        assertEquals(newBrand.productList(), updatedBrand.productList());
        assertEquals(newBrand.display_name(), updatedBrand.display_name());

    }

}
