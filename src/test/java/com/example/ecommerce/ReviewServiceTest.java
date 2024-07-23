package com.example.ecommerce;

import com.example.ecommerce.domain.dto.ReviewDTO;
import com.example.ecommerce.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReviewServiceTest {

    @InjectMocks
    private ReviewService reviewService;

    @Test
    public void testReviewCreate(){
        ReviewDTO newReview = new ReviewDTO(null, 1, "A good job", new Date(), null, null);

        ReviewDTO createdReview = this.reviewService.create(newReview);

        assertEquals(newReview.avaliation_value(), createdReview.avaliation_value());
        assertEquals(newReview.comment(), createdReview.comment());
        assertEquals(newReview.date(), createdReview.date());
        assertEquals(newReview.product(), createdReview.product());
        assertEquals(newReview.user(), createdReview.user());

    }

    @Test
    public void testReviewUpdate(){
        ReviewDTO newReview = new ReviewDTO(null, 5, "A good job", new Date(), null, null);

        ReviewDTO createdReview = this.reviewService.create(newReview);

        ReviewDTO updateReviewDTO = new ReviewDTO(createdReview.id(), 2, "A bad job", new Date(), null, null);

        ReviewDTO updatedReview = this.reviewService.update(createdReview.id(), updateReviewDTO);

        assertEquals(updateReviewDTO.avaliation_value(), updatedReview.avaliation_value());
        assertEquals(updateReviewDTO.comment(), updatedReview.comment());
        assertEquals(updateReviewDTO.date(), updatedReview.date());
        assertEquals(updateReviewDTO.product(), updatedReview.product());
        assertEquals(updateReviewDTO.user(), updatedReview.user());
    }

}
