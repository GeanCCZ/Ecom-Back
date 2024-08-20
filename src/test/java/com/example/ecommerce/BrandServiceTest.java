package com.example.ecommerce;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.BrandDTO;
import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.BrandRepository;
import com.example.ecommerce.service.BrandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class BrandServiceTest {

    @InjectMocks
    private BrandService brandService;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private CRUDRepository<Brand, UUID> repository;

    @Mock
    private Adapter<Brand, BrandDTO> brandAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBrandCreate() {
        BrandDTO brandDTO = new BrandDTO(null, "Bingo", "A new way to search your thoughts", null, null);
        Brand newBrand = new Brand();

        newBrand.setId(brandDTO.id());
        newBrand.setDisplayName(brandDTO.displayName());
        newBrand.setDescription(brandDTO.description());
        newBrand.setProductList(brandDTO.productList());
        newBrand.setImage(brandDTO.image());

        when(brandAdapter.fromDto(any(BrandDTO.class))).thenReturn(newBrand);
        when(repository.save(any(Brand.class))).thenReturn(newBrand);
        when(repository.findAll()).thenReturn(Collections.singletonList(newBrand));

        BrandDTO createdBrand = this.brandService.create(brandDTO);
        List<Brand> allBrands = this.brandService.findAll();

        assertEquals(1, allBrands.size());
        assertEquals(newBrand, allBrands.get(0));
    }

    @Test
    void testBrandUpdate() {
        BrandDTO brandDTO = new BrandDTO(UUID.randomUUID(), "Bingo", "A new way to search your thoughts", null, null);
        Brand newBrand = new Brand();

        newBrand.setId(brandDTO.id());
        newBrand.setDisplayName(brandDTO.displayName());
        newBrand.setDescription(brandDTO.description());
        newBrand.setProductList(brandDTO.productList());
        newBrand.setImage(brandDTO.image());

        when(brandAdapter.fromDto(any(BrandDTO.class))).thenReturn(newBrand);
        when(repository.save(any(Brand.class))).thenReturn(newBrand);
        when(repository.findById(brandDTO.id())).thenReturn(Optional.of(newBrand));
        when(brandService.create(brandDTO)).thenReturn(brandDTO);

        BrandDTO createdBrandDTO = brandService.create(brandDTO);
        BrandDTO updateBrandDTO = new BrandDTO(createdBrandDTO.id(), "Guugle", "Open your mind", null, null);
        Brand updatedBrand = brandAdapter.fromDto(updateBrandDTO);

        when(brandAdapter.fromDto(any(BrandDTO.class))).thenReturn(updatedBrand);
        when(repository.save(any(Brand.class))).thenReturn(updatedBrand);

        BrandDTO result = brandService.update(createdBrandDTO.id(), updateBrandDTO);

        verify(this.repository).save(updatedBrand);

        assertEquals(updateBrandDTO.displayName(), updatedBrand.getDisplayName());
        assertEquals(updateBrandDTO.description(), updatedBrand.getDescription());
        assertEquals(updateBrandDTO.productList(), updatedBrand.getProductList());
    }
}