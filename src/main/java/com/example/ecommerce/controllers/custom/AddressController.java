package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.AddressDTO;
import com.example.ecommerce.domain.entities.Address;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("address")
public class AddressController extends CRUDController<Address, UUID, AddressDTO> {

    public AddressController(CRUDService<Address, UUID, AddressDTO> service){
        super(service);
    }

}
