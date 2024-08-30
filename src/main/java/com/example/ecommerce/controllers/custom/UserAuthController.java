package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.domain.dto.GenericSucessfulOperation;
import com.example.ecommerce.domain.dto.UserAuthDTO;
import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.domain.entities.LoginResponse;
import com.example.ecommerce.domain.entities.UserAuth;
import com.example.ecommerce.service.Auth.AuthService;
import com.example.ecommerce.service.Auth.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserAuthController {

    private final JwtService jwtService;

    private final AuthService authService;

    public UserAuthController(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping("/signup")
    public GenericSucessfulOperation<UserAuthDTO> signUp(@RequestBody UserDTO userDTO) {

        return this.authService.signUp(userDTO);
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> signIn(@RequestBody UserAuthDTO userAuthDTO) {
        System.out.println("jwtToken");
        UserAuth authenticatedUser = this.authService.signIn(userAuthDTO);

        String jwtToken = this.jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
