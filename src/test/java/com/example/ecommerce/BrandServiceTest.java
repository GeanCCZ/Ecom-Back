package com.example.ecommerce;

import com.example.ecommerce.domain.dto.BrandDTO;
import com.example.ecommerce.service.BrandService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BrandServiceTest {

    @Autowired
    private static BrandService brandService;

    private static final BrandDTO brandDTO = new BrandDTO(null,"Guugle","A new way to search your thoughts",null,null);

    private BrandDTO createdBrand;

    @BeforeEach
    public void createBrandInDB(){
        this.createdBrand = this.brandService.create(this.brandDTO);
    }

    @Test
    public void testBrandCreate(){

        assertEquals(this.brandDTO.description(), this.createdBrand.description());
        assertEquals(this.brandDTO.image(), this.createdBrand.image());
        assertEquals(this.brandDTO.productList(), this.createdBrand.productList());
        assertEquals(this.brandDTO.display_name(), this.createdBrand.display_name());
    }

    @Test
    public void testBrandUpdate(){

        BrandDTO updateBrandDTO = new BrandDTO(this.createdBrand.id(),"Amazonas Delivery", "A big big",null,null);

        BrandDTO updatedBrand = this.brandService.update(this.createdBrand.id(), updateBrandDTO);

        assertEquals(updateBrandDTO.description(), updatedBrand.description());
        assertEquals(updateBrandDTO.image(), updatedBrand.image());
        assertEquals(updateBrandDTO.productList(), updatedBrand.productList());
        assertEquals(updateBrandDTO.display_name(), updatedBrand.display_name());

    }

}
