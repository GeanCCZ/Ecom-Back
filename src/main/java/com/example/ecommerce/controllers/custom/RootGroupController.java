package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.RootGroupDTO;
import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.domain.entities.RootGroup;
import com.example.ecommerce.service.CRUDService;
import com.example.ecommerce.service.RootGroupService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("rootGroup")
public class RootGroupController extends CRUDController<RootGroup, UUID, RootGroupDTO> {

    private final RootGroupService rootGroupService;
    public RootGroupController(CRUDService<RootGroup,UUID,RootGroupDTO> service, RootGroupService rootGroupService){
        super(service);
        this.rootGroupService = rootGroupService;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public RootGroupDTO create(@RequestPart(value = "rootGroup") @Valid RootGroupDTO dto, @RequestPart(value = "image",required = false) Image image){
        return this.rootGroupService.create(dto);
    }

}
