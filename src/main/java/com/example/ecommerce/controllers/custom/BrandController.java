package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.BrandDTO;
import com.example.ecommerce.domain.entities.Brand;
import com.example.ecommerce.service.CRUDService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("brand")
public class BrandController extends CRUDController<Brand, UUID, BrandDTO> {

    private final CRUDService<Brand,UUID,BrandDTO> service;

    public BrandController(CRUDService<Brand,UUID,BrandDTO> service){
        super(service);
        this.service = service;
    }


    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public BrandDTO create(@RequestPart("brand") @Valid BrandDTO dto, @RequestPart(value = "image", required = false) MultipartFile image) {
        System.out.println("BrandController.create" + dto);
        return this.service.create(dto);
    }

}
