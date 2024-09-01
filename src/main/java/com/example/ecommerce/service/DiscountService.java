package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.DiscountDTO;
import com.example.ecommerce.domain.entities.Discount;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.DiscountRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DiscountService extends CRUDService<Discount, UUID, DiscountDTO> {

    private final DiscountRepository discountRepository;

    private final Adapter<Discount,DiscountDTO> adapter;

    public DiscountService(CRUDRepository<Discount,UUID> repository, Adapter<Discount, DiscountDTO> adapter, DiscountRepository discountRepository){
        super(repository,adapter);
        this.discountRepository = discountRepository;
        this.adapter = adapter;
    }

    @Override
    protected void checkSave(DiscountDTO dto, Discount entity){
        boolean alreadyExists = this.discountRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new ObjectNotFoundException(dto.getClass(), "Discount");
        }
    }

    @Override
    protected Discount getEntityFromDTO(DiscountDTO dto){ return this.adapter.fromDto(dto); }

    @Override
    protected DiscountDTO getDTOFromEntity(Discount entity){ return this.adapter.fromEntity(entity); }

}
