package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.DiscountDTO;
import com.example.ecommerce.domain.entities.Discount;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("discount")
public class DiscountController extends CRUDController<Discount, UUID, DiscountDTO> {

    public DiscountController(CRUDService<Discount, UUID, DiscountDTO> service){
        super(service);
    }

}
