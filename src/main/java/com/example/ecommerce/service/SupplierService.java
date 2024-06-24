package com.example.ecommerce.service;

import com.example.ecommerce.adapter.Adapter;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Supplier;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SupplierService extends CRUDService<Supplier, UUID, SupplierDTO>{

    private final SupplierRepository supplierRepository;

    public SupplierService(CRUDRepository<Supplier,UUID> repository, Adapter<Supplier, SupplierDTO> adapter, SupplierRepository supplierRepository){
        super(repository,adapter);
        this.supplierRepository = supplierRepository;

    }

    @Override
    protected void checkSave(){

    }

}
