package com.example.ecommerce.service.Auth;

import com.example.ecommerce.domain.dto.GenericSucessfulOperation;
import com.example.ecommerce.domain.dto.UserAuthDTO;
import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.domain.entities.UserAuth;
import com.example.ecommerce.repository.custom.UserRepository;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public GenericSucessfulOperation<UserAuthDTO> signUp(UserDTO userDTO) {

        UserAuthDTO userAuthDTO = new UserAuthDTO(userDTO.email(), "");

        GenericSucessfulOperation<UserAuthDTO> userCreationResponse = new GenericSucessfulOperation<UserAuthDTO>(userAuthDTO,"User created successfully");

        userService.create(userDTO);

        return userCreationResponse;
    }

    public UserAuth signIn(UserAuthDTO userAuthDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userAuthDTO.email(), userAuthDTO.password())
        );

        //FIX
        System.out.println("----------");

        if(userService.findByEmail(userAuthDTO.email()).isEmpty()){
            throw new RuntimeException("User not found");
        }

        UserAuth userAuth = new UserAuth(userAuthDTO.email(), userAuthDTO.password());

        return userAuth;
    }
}
