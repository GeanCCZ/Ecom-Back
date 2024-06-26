package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Supplier;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("supplier")
public class SupplierController extends CRUDController<Supplier,UUID,SupplierDTO> {

    public SupplierController(CRUDService<Supplier, UUID, SupplierDTO> service){
        super(service);
    }

}
