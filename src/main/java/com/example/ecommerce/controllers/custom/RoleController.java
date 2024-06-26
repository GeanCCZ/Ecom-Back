package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.RoleDTO;
import com.example.ecommerce.domain.entities.Role;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("role")
public class RoleController extends CRUDController<Role, UUID, RoleDTO> {

    public RoleController(CRUDService<Role, UUID,RoleDTO> service){
        super(service);
    }

}
