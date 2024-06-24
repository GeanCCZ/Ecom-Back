package com.example.ecommerce.service;

import com.example.ecommerce.adapter.Adapter;
import com.example.ecommerce.domain.dto.BrandDTO;
import com.example.ecommerce.domain.dto.ProductDTO;
import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BrandService extends CRUDService<Brand, UUID, BrandDTO>{

    private final BrandRepository brandRepository;

    public BrandService(CRUDRepository<Brand,UUID> repository, Adapter<Brand, BrandDTO> adapter, BrandRepository brandRepository){
        super(repository,adapter);
        this.brandRepository = brandRepository;
    }

    @Override
    protected void checkSave(BrandDTO dto,Brand entity){
        boolean alreadyExists = this.brandRepository.findByDisplayName(dto.display_name()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }
}