package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.domain.dto.GenericSucessfulOperation;
import com.example.ecommerce.domain.dto.UserAuthDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserAuthController {

    public GenericSucessfulOperation<UserAuthDTO> signUp(UserAuthDTO userAuthDTO) {
        return null;
    }

    public GenericSucessfulOperation<UserAuthDTO> signIn(UserAuthDTO userAuthDTO) {
        return null;
    }

}
