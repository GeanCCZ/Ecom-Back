package com.example.ecommerce.service;

import com.example.ecommerce.adapter.Adapter;
import com.example.ecommerce.domain.dto.ReviewDTO;
import com.example.ecommerce.domain.entities.Review;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewService extends CRUDService<Review, UUID, ReviewDTO>{

    private final ReviewRepository reviewRepository;

    public ReviewService(CRUDRepository<Review,UUID> repository, Adapter<Review,ReviewDTO > adapter, ReviewRepository reviewRepository){
        super(repository,adapter);
        this.reviewRepository = reviewRepository;
    }

    @Override
    protected void checkSave(ReviewDTO dto, Review entity){
        boolean alreadyExists = this.reviewRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

}
