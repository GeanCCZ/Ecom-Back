package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.AddressDTO;
import com.example.ecommerce.domain.entities.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressAdapter implements Adapter<Address, AddressDTO>{

    @Override
    public Address fromDto(AddressDTO dto){
        return new Address(
                dto.street(),
                dto.number(),
                dto.cep(),
                dto.city(),
                dto.state(),
                dto.country(),
                dto.complement(),
                dto.neighborhood(),
                dto.supplier(),
                dto.user()
        );
    };

    @Override
    public AddressDTO fromEntity(Address entity){
        return new AddressDTO(
                entity.getId(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getCep(),
                entity.getCity(),
                entity.getState(),
                entity.getCountry(),
                entity.getComplement(),
                entity.getNeighborhood(),
                entity.getSupplier(),
                entity.getUser()
        );
    };

}
