package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.ProductDTO;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService extends CRUDService<Product, UUID, ProductDTO>{

    private final ProductRepository productRepository;

    public ProductService (CRUDRepository<Product,UUID> repository, Adapter<Product,ProductDTO> adapter,ProductRepository productRepository){
        super(repository,adapter);
        this.productRepository = productRepository;
    }

    @Override
    protected void checkSave(ProductDTO dto, Product entity) {
        boolean alreadyExists = this.productRepository.findByDisplayName(dto.display_name()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }
}
