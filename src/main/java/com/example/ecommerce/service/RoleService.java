package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.RoleDTO;
import com.example.ecommerce.domain.entities.Role;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService extends CRUDService<Role, UUID, RoleDTO>{

    private final RoleRepository roleRepository;

    public RoleService(CRUDRepository<Role,UUID> repository, Adapter<Role,RoleDTO > adapter,RoleRepository roleRepository){
        super(repository,adapter);
        this.roleRepository = roleRepository;
    }

    @Override
    protected void checkSave(RoleDTO dto, Role entity){
        boolean alreadyExists = this.roleRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

}
