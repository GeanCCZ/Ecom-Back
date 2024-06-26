package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.ImageDTO;
import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("image")
public class ImageController extends CRUDController<Image, UUID, ImageDTO> {
    public ImageController(CRUDService<Image, UUID, ImageDTO> service){
        super(service);
    }
}
