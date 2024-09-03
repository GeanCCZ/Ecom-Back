package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.BrandDTO;
import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.BrandRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.Optional;
import java.util.UUID;

@Service
public class BrandService extends CRUDService<Brand, UUID, BrandDTO>{

    private final BrandRepository brandRepository;

    public BrandService(CRUDRepository<Brand,UUID> repository, Adapter<Brand, BrandDTO> adapter, BrandRepository brandRepository){
        super(repository,adapter);
        this.brandRepository = brandRepository;
    }

    @SneakyThrows
    @Override
    protected void checkSave(BrandDTO dto,Brand entity){
        boolean alreadyExists = this.brandRepository.findByDisplayName(dto.displayName()).isPresent();
        if(alreadyExists){
            throw new InstanceAlreadyExistsException("Brand already exists");
        }
    }

    public Optional<Brand> findByDisplayName(String displayName){
        return this.brandRepository.findByDisplayName(displayName);
    }
}
