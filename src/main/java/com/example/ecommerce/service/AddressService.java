package com.example.ecommerce.service;

import com.example.ecommerce.adapter.Adapter;
import com.example.ecommerce.domain.dto.AddressDTO;
import com.example.ecommerce.domain.entities.Address;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService extends CRUDService<Address, UUID, AddressDTO>{

    private final AddressRepository addressRepository;

    public AddressService(CRUDRepository<Address,UUID> repository, Adapter<Address, AddressDTO> adapter, AddressRepository addressRepository){
        super(repository,adapter);
        this.addressRepository = addressRepository;
    }

    @Override
    protected void checkSave(AddressDTO dto, Address entity){
        boolean alreadyExists = this.addressRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

}
