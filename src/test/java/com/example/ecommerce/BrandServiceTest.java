package com.example.ecommerce.service;

import com.example.ecommerce.adapters.BrandAdapter;
import com.example.ecommerce.domain.dto.BrandDTO;
import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.repository.custom.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class BrandServiceTest {

    @Mock
    private BrandService brandService;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private BrandAdapter brandAdapter;

    @BeforeEach
    void setUp() {
        brandRepository = mock(BrandRepository.class);
        brandAdapter = new BrandAdapter();
        brandService = new BrandService(brandRepository, brandAdapter, brandRepository);
    }

    @Test
    void createBrandSuccessfully() {
        BrandDTO brandDTO = new BrandDTO(UUID.randomUUID(), "BrandName", "Description", null, null);
        Brand brand = new Brand("BrandName", "Description", null, null);

        when(brandRepository.save(any(Brand.class))).thenReturn(brand);
        when(brandRepository.findByDisplayName(anyString())).thenReturn(Optional.empty());

        BrandDTO createdBrand = brandService.create(brandDTO);

        assertNotNull(createdBrand);
        assertEquals("BrandName", createdBrand.displayName());
    }

    @Test
    void createBrandAlreadyExists() {
        BrandDTO brandDTO = new BrandDTO(UUID.randomUUID(), "BrandName", "Description", null, null);
        Brand brand = new Brand(brandDTO.displayName(), brandDTO.description(), brandDTO.image(), brandDTO.productList());

        when(brandRepository.findByDisplayName(anyString())).thenReturn(Optional.of(brand));

        assertThrows(RuntimeException.class, () -> brandService.create(brandDTO));
    }

    @Test
    void updateBrandSuccessfully() {
        UUID id = UUID.randomUUID();
        BrandDTO brandDTO = new BrandDTO(id, "UpdatedName", "UpdatedDescription", null, null);
        Brand brand = new Brand(brandDTO.displayName(), brandDTO.description(), brandDTO.image(), brandDTO.productList());

        when(brandRepository.findById(id)).thenReturn(Optional.of(brand));
        when(brandRepository.save(any(Brand.class))).thenReturn(brand);

        BrandDTO updatedBrand = brandService.update(id, brandDTO);

        verify(brandRepository).save(any(Brand.class));
        verify(brandRepository, Mockito.times(2)).findById(id);

        assertNotNull(updatedBrand);
        assertEquals("UpdatedName", updatedBrand.displayName());
    }

    @Test
    void updateBrandNotFound() {
        UUID id = UUID.randomUUID();
        BrandDTO brandDTO = new BrandDTO(id, "UpdatedName", "UpdatedDescription", null, null);

        when(brandRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> brandService.update(id, brandDTO));
    }

    @Test
    void deleteBrandSuccessfully() {
        UUID id = UUID.randomUUID();
        BrandDTO brandDTO = new BrandDTO(id, "BrandName", "Description", null, null);
        Brand brand = new Brand(brandDTO.displayName(), brandDTO.description(), brandDTO.image(), brandDTO.productList());

        when(brandRepository.findById(id)).thenReturn(Optional.of(brand));

        brandService.delete(id);

        verify(brandRepository).delete(brand);
    }

    @Test
    void findByDisplayNameSuccessfully() {
        Brand brand = new Brand("BrandName", "Description", null, null);

        when(brandRepository.findByDisplayName("BrandName")).thenReturn(Optional.of(brand));

        Optional<Brand> foundBrand = brandService.findByDisplayName("BrandName");

        assertTrue(foundBrand.isPresent());
        assertEquals("BrandName", foundBrand.get().getDisplayName());
    }

    @Test
    void findByDisplayNameNotFound() {
        when(brandRepository.findByDisplayName("NonExistentBrand")).thenReturn(Optional.empty());

        Optional<Brand> foundBrand = brandService.findByDisplayName("NonExistentBrand");

        assertFalse(foundBrand.isPresent());
    }
}