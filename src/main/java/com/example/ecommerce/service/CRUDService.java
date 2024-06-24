package com.example.ecommerce.service;

import com.example.ecommerce.adapter.Adapter;
import com.example.ecommerce.repository.CRUDRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class CRUDService<T, ID, DTO>{

    private final CRUDRepository<T,ID> repository;

    private final Adapter<T, DTO> adapter;

    public DTO create(DTO dto){
        T newEntity = this.getEntityFromDTO(dto);

        return this.getDTOFromEntity(repository.save(newEntity));
    }

    public DTO update(ID id,DTO dto){
        T entity = this.findById(id);
        checkSave(dto,entity);
        T updatedEntity = this.getEntityFromDTO(dto);

        return  this.getDTOFromEntity(this.repository.save(updatedEntity));
    }

    public void delete(ID id){
        this.repository.deleteById(id);
    }

    public List<T> findAll(){
        return this.repository.findAll();
    }

    public T findById(ID id){
        return this.repository.findById(id).isPresent() ? this.repository.findById(id).get() : null;
    }

    protected abstract void checkSave(DTO dto, T entityToSave);

    private DTO getDTOFromEntity(T entity){ return adapter.fromEntity(entity); }

    private T getEntityFromDTO(DTO dto){ return adapter.fromDto(dto);}
}