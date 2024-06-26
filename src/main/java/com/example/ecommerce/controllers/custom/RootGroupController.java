package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.RootGroupDTO;
import com.example.ecommerce.domain.entities.RootGroup;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("rootGroup")
public class RootGroupController extends CRUDController<RootGroup, UUID, RootGroupDTO> {

    public RootGroupController(CRUDService<RootGroup,UUID,RootGroupDTO> service){
        super(service);
    }

}
