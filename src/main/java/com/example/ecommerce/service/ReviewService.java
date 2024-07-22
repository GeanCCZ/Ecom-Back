package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.ReviewDTO;
import com.example.ecommerce.domain.entities.Review;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewService extends CRUDService<Review, UUID, ReviewDTO>{

    private final ReviewRepository reviewRepository;
    private final ProductService productService;

    public ReviewService(CRUDRepository<Review,UUID> repository, Adapter<Review,ReviewDTO > adapter, ReviewRepository reviewRepository, ProductService productService){
        super(repository,adapter);
        this.reviewRepository = reviewRepository;
        this.productService = productService;
    }

    @Override
    public ReviewDTO create(ReviewDTO dto){
        if(!this.productService.findById(dto.product().getId()).getDisplayName().isEmpty()){
            throw new RuntimeException("Product not found");
        }

        return this.getDTOFromEntity(this.reviewRepository.save(this.getEntityFromDTO(dto)));
    }

    @Override
    protected void checkSave(ReviewDTO dto, Review entity){
        boolean alreadyExists = this.reviewRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

}
