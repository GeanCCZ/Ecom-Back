package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.SubCategoryDTO;
import com.example.ecommerce.domain.entities.SubCategory;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SubCategoryService extends CRUDService<SubCategory, UUID, SubCategoryDTO>{

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(CRUDRepository<SubCategory,UUID> repository, Adapter<SubCategory,SubCategoryDTO> adapter, SubCategoryRepository subCategoryRepository){
        super(repository,adapter);
        this.subCategoryRepository=subCategoryRepository;
    }

    @Override
    protected void checkSave(SubCategoryDTO dto, SubCategory entity){
        boolean alreadyExists = this.subCategoryRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

    public Optional<SubCategory> findByDisplayName(String displayName){
        return this.subCategoryRepository.findByDisplayName(displayName);
    };

}
