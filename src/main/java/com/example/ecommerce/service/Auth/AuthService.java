package com.example.ecommerce.service.Auth;

import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.domain.entities.User;
import com.example.ecommerce.repository.custom.UserRepository;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public UserDTO signUp(UserDTO userDTO) {

        UserDTO encodedPasswordUserDTO = new UserDTO(null, userDTO.addresses(), userDTO.role(), userDTO.image(), userDTO.orderList(), userDTO.reviewList(), userDTO.firstName(), userDTO.lastName(), userDTO.email(), userDTO.phone(), passwordEncoder.encode(userDTO.password()), true, userDTO.createdAt());
        userService.create(encodedPasswordUserDTO);

        return new UserDTO(null, userDTO.addresses(), userDTO.role(), userDTO.image(), userDTO.orderList(), userDTO.reviewList(), userDTO.firstName(), userDTO.lastName(), userDTO.email(), userDTO.phone(), null, true, userDTO.createdAt());
    }

    public User signIn(UserDTO userDTO) {
        authenticateUser(userDTO.email(), userDTO.password());

        Optional<User> user = userService.findByEmail(userDTO.email());

        if (user.isEmpty()) {
            throw new ObjectNotFoundException(UserDTO.class, "email");
        }

        return user.get();
    }

    private void authenticateUser(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

    }
}
