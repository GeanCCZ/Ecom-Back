package com.example.ecommerce.controllers.custom;


import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.ProductDTO;
import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.domain.entities.Product;
import com.example.ecommerce.service.CRUDService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController extends CRUDController<Product, UUID, ProductDTO> {

    private final CRUDService<Product,UUID,ProductDTO> service;
    public ProductController(CRUDService<Product,UUID,ProductDTO> service){
        super(service);
        this.service = service;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ProductDTO create(@RequestPart("product") @Valid ProductDTO dto, @RequestPart(value = "imageList",required = false) Image image){
        return this.service.create(dto);
    }

}
