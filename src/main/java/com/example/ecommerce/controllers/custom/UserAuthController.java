package com.example.ecommerce.controllers.custom;

import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.domain.entities.LoginResponse;
import com.example.ecommerce.domain.entities.User;
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
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO) {

        return ResponseEntity.ok(this.authService.signUp(userDTO));
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> signIn(@RequestBody UserDTO userDTO) {
        User authenticatedUser = this.authService.signIn(userDTO);

        String jwtToken = this.jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
