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

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class BrandServiceTest {

    @InjectMocks
    private static BrandService brandService;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private CRUDRepository<Brand, UUID> repository;

    @Mock
    private Adapter<Brand, BrandDTO> brandAdapter;

    @Test
    void testBrandCreate() {
        BrandDTO brandDTO = new BrandDTO(null, "Bingo", "A new way to search your thoughts", null, null);
        Brand newBrand = new Brand();

        newBrand.setId(brandDTO.id());
        newBrand.setDisplayName(brandDTO.display_name());
        newBrand.setDescription(brandDTO.description());
        newBrand.setProductList(brandDTO.productList());
        newBrand.setImage(brandDTO.image());

        when(brandAdapter.fromDto(any(BrandDTO.class))).thenReturn(newBrand);
        when(repository.save(any(Brand.class))).thenReturn(newBrand);

        this.brandService.create(brandDTO);

        verify(this.repository).save(newBrand);
        verify(this.brandAdapter).fromEntity(newBrand);

        assertEquals(brandDTO.display_name(), newBrand.getDisplayName());
        assertEquals(brandDTO.description(), newBrand.getDescription());
        assertEquals(brandDTO.productList(), newBrand.getProductList());
        assertEquals(brandDTO.image(), newBrand.getImage());
    }

    @Test
    void testBrandUpdate() {
        BrandDTO brandDTO = new BrandDTO(null, "Bingo", "A new way to search your thoughts", null, null);
        Brand newBrand = new Brand();
        newBrand.setId(UUID.randomUUID());
        newBrand.setDisplayName(brandDTO.display_name());
        newBrand.setDescription(brandDTO.description());
        newBrand.setProductList(brandDTO.productList());
        newBrand.setImage(brandDTO.image());

        when(brandAdapter.fromDto(any(BrandDTO.class))).thenReturn(newBrand);
        when(this.repository.save(any(Brand.class))).thenReturn(newBrand);
        when(brandAdapter.fromEntity(any(Brand.class))).thenReturn(brandDTO);

        BrandDTO createdBrandDTO = this.brandService.create(brandDTO);
        Brand createdBrand = brandAdapter.fromDto(createdBrandDTO);

        when(this.repository.findById(createdBrand.getId())).thenReturn(java.util.Optional.of(createdBrand));

        BrandDTO updateBrandDTO = new BrandDTO(createdBrand.getId(), "Guugle", "Open your mind", null, null);
        Brand updatedBrand = brandAdapter.fromDto(updateBrandDTO);

        when(brandAdapter.fromDto(any(BrandDTO.class))).thenReturn(updatedBrand);
        when(this.repository.save(any(Brand.class))).thenReturn(updatedBrand);

        BrandDTO result = this.brandService.update(createdBrand.getId(), updateBrandDTO);

        verify(this.repository).save(updatedBrand);

        assertEquals(updateBrandDTO.display_name(), updatedBrand.getDisplayName());
        assertEquals(updateBrandDTO.description(), updatedBrand.getDescription());
        assertEquals(updateBrandDTO.productList(), updatedBrand.getProductList());
    }
}