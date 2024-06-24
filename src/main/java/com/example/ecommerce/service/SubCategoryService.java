package com.example.ecommerce.service;

import com.example.ecommerce.adapter.Adapter;
import com.example.ecommerce.domain.dto.SubCategoryDTO;
import com.example.ecommerce.domain.entities.SubCategory;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubCategoryService extends CRUDService<SubCategory, UUID, SubCategoryDTO>{

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(CRUDRepository<SubCategory,UUID> repository, Adapter<SubCategory,SubCategoryDTO> adapter, SubCategoryRepository subCategoryRepository){
        super(repository,adapter);
        this.subCategoryRepository=subCategoryRepository;
    }

    @Override
    protected void checkSave(){

    }

}
