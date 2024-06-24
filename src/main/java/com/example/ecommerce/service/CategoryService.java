package com.example.ecommerce.service;

import com.example.ecommerce.adapter.Adapter;
import com.example.ecommerce.domain.dto.CategoryDTO;
import com.example.ecommerce.domain.entities.Category;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.CategoryRepository;

import java.util.UUID;

public class CategoryService extends  CRUDService<Category,UUID, CategoryDTO>{

    private final CategoryRepository categoryRepository;

    public CategoryService(CRUDRepository<Category, UUID> repository, Adapter<Category, CategoryDTO> adapter, CategoryRepository categoryRepository){
        super(repository,adapter);
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected void checkSave(CategoryDTO dto,Category entity){
            boolean alreadyExists = this.categoryRepository.findByDisplayName(dto.display_name()).isPresent();
            if(alreadyExists){
                throw new RuntimeException();
            }
    }

}
