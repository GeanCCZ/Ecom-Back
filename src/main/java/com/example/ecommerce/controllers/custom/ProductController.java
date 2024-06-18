package com.example.ecommerce.controllers.custom;


import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.ProductDTO;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController extends CRUDController<Product, UUID, ProductDTO> {

    public ProductController(CRUDService<Product,UUID,ProductDTO> service){
        super(service);
    }
}
