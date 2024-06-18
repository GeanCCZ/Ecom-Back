package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.ReviewDTO;
import com.example.ecommerce.domain.entities.Review;

public class ReviewAdapter implements Adapter<Review, ReviewDTO> {

    @Override
    public Review fromDto(ReviewDTO dto) {
        return new Review(
                dto.avaliation_value(),
                dto.comment(),
                dto.date(),
                dto.product(),
                dto.user()
        );
    }

    @Override
    public ReviewDTO fromEntity(Review entity) {
        return new ReviewDTO(
                entity.getAvaliationValue(),
                entity.getComment(),
                entity.getDate(),
                entity.getProduct(),
                entity.getUser()
        );
    }
}
