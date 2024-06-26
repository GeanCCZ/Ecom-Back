package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.controllers.CRUDController;
import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.domain.entities.User;
import com.example.ecommerce.service.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController extends CRUDController<User, UUID, UserDTO> {

    public UserController(CRUDService<User,UUID,UserDTO> service){
        super(service);
    }

}
