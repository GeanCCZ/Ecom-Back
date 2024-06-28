package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.domain.entities.Image;
import com.example.ecommerce.domain.entities.User;
import com.example.ecommerce.service.CRUDService;
import com.example.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController extends CRUDController<User, UUID, UserDTO> {

    private final UserService userService;

    public UserController(CRUDService<User,UUID,UserDTO> service, UserService userService){
        super(service);
        this.userService = userService;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public UserDTO create(@RequestPart("user") @Valid UserDTO dto, @RequestPart(value = "image",required = false) Image image){
        return this.userService.create(dto);
    }

}
