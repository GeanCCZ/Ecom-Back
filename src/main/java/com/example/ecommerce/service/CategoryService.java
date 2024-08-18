package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.CategoryDTO;
import com.example.ecommerce.domain.entities.Category;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService extends  CRUDService<Category,UUID, CategoryDTO>{

    private final CategoryRepository categoryRepository;

    public CategoryService(CRUDRepository<Category, UUID> repository, Adapter<Category, CategoryDTO> adapter, CategoryRepository categoryRepository){
        super(repository,adapter);
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected void checkSave(CategoryDTO dto,Category entity){
        boolean alreadyExists = this.categoryRepository.findByDisplayName(dto.displayName()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

    protected Optional<Category> findByDisplayName(String displayName){
        return this.categoryRepository.findByDisplayName(displayName);
    }

}
