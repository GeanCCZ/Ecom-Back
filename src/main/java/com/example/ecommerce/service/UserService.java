package com.example.ecommerce.service;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.domain.entities.User;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService extends CRUDService<User, UUID, UserDTO>{

    private final UserRepository userRepository;

    public UserService(CRUDRepository<User,UUID> repository, Adapter<User, UserDTO> adapter, UserRepository userRepository){
        super(repository,adapter);
        this.userRepository = userRepository;
    }

    @Override
    protected void checkSave(UserDTO dto, User entity){
        boolean alreadyExists = this.userRepository.findById(dto.id()).isPresent();
        if(alreadyExists){
            throw new RuntimeException();
        }
    }

    public Optional<User> findByEmail(String email){
        return Optional.of(this.userRepository.findByEmail(email).orElseThrow());
    }

}
