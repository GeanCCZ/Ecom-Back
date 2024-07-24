package com.example.ecommerce;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.BrandDTO;
import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.BrandRepository;
import com.example.ecommerce.service.BrandService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BrandServiceTest {

    @InjectMocks
    private static BrandService brandService;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private CRUDRepository<Brand, BrandDTO> repository;

    @Mock
    private Adapter<Brand,BrandDTO> brandAdapter;

    @Test
    public void testBrandCreate(){
        BrandDTO brandDTO = new BrandDTO(null,"Bingo","A new way to search your thoughts",null,null);
        Brand newBrand = new Brand();

        newBrand.setId(brandDTO.id());
        newBrand.setDisplayName(brandDTO.display_name());
        newBrand.setDescription(brandDTO.description());
        newBrand.setProductList(brandDTO.productList());
        newBrand.setImage(brandDTO.image());

        when(brandAdapter.fromDto(any(BrandDTO.class))).thenReturn(newBrand);

        when(repository.save(any(Brand.class))).thenReturn(newBrand);

        brandService.create(brandDTO);

        verify(repository).save(newBrand);
        verify(brandAdapter).fromEntity(newBrand);

        assertEquals(brandDTO.display_name(), newBrand.getDisplayName());
        assertEquals(brandDTO.description(), newBrand.getDescription());
        assertEquals(brandDTO.productList(), newBrand.getProductList());
        assertEquals(brandDTO.image(), newBrand.getImage());
    }

    @Test
    public void testBrandUpdate(){



    }

}
