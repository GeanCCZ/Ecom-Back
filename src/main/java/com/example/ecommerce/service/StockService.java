package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.StockDTO;
import com.example.ecommerce.domain.entities.Stock;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.StockRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StockService extends CRUDService<Stock, UUID,StockDTO>{
    private final StockRepository stockRepository;

    public StockService(CRUDRepository<Stock,UUID> repository, Adapter<Stock, StockDTO> adapter, StockRepository stockRepository){
        super(repository,adapter);
        this.stockRepository = stockRepository;
    }

    @Override
    protected void checkSave(StockDTO dto, Stock entity){
        boolean alreadyExists = this.stockRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

}
