package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Supplier;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SupplierService extends CRUDService<Supplier, UUID, SupplierDTO>{

    private final SupplierRepository supplierRepository;

    public SupplierService(CRUDRepository<Supplier,UUID> repository, Adapter<Supplier, SupplierDTO> adapter, SupplierRepository supplierRepository){
        super(repository,adapter);
        this.supplierRepository = supplierRepository;
    }

    @Override
    protected void checkSave(SupplierDTO dto, Supplier entity){
        boolean alreadyExists = this.supplierRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

    public Optional<Supplier> findByTradeName(String tradeName){
        return this.supplierRepository.findByTradeName(tradeName);
    }

    public Optional<Supplier> findByLegalName(String legalName){
        return this.supplierRepository.findByLegalName(legalName);
    }

}
