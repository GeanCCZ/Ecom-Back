package com.example.ecommerce.service;

import com.example.ecommerce.adapter.Adapter;
import com.example.ecommerce.domain.dto.RootGroupDTO;
import com.example.ecommerce.domain.entities.RootGroup;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.RootGroupRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RootGroupService extends CRUDService<RootGroup, UUID, RootGroupDTO>{

    private final RootGroupRepository rootGroupRepository;

    public RootGroupService(CRUDRepository<RootGroup,UUID> repository, Adapter<RootGroup,RootGroupDTO > adapter, RootGroupRepository rootGroupRepository){
        super(repository,adapter);
        this.rootGroupRepository = rootGroupRepository

    }

    @Override
    protected void checkSave(){
        boolean alreadyExists = this.
    }

}
