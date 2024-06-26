package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.ReviewDTO;
import com.example.ecommerce.domain.entities.Review;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("review")
public class ReviewController extends CRUDController<Review, UUID, ReviewDTO> {

    public ReviewController(CRUDService<Review,UUID,ReviewDTO> service){
        super(service);
    }

}
