package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.repository.CRUDRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class CRUDService<T, ID, DTO>{

    private final CRUDRepository<T,ID> repository;

    private final Adapter<T, DTO> adapter;

    public DTO create(DTO dto){
        T newEntity = this.getEntityFromDTO(dto);

        DTO createdRegister = this.getDTOFromEntity(repository.save(newEntity));

        return createdRegister;
    }

    public DTO update(ID id,DTO dto){
        if(this.findById(id) == null){
            throw new RuntimeException("Register not found");
        }
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

    protected DTO getDTOFromEntity(T entity) {
        System.out.println(entity);
        return adapter.fromEntity(entity);
    }

    protected T getEntityFromDTO(DTO dto){ return adapter.fromDto(dto);}
}
