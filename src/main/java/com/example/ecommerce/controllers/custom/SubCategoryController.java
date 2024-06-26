package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.SubCategoryDTO;
import com.example.ecommerce.domain.entities.SubCategory;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("subCategory")
public class SubCategoryController extends CRUDController<SubCategory, UUID, SubCategoryDTO> {

    public SubCategoryController(CRUDService<SubCategory,UUID,SubCategoryDTO> service){
        super(service);
    }

}
