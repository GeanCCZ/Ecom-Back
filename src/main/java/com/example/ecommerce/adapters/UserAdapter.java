package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.domain.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserAdapter implements Adapter<User, UserDTO> {

    @Override
    public User fromDto(UserDTO dto) {
        return new User(
                dto.address(),
                dto.role(),
                dto.image(),
                dto.orders(),
                dto.reviewList(),
                dto.first_name(),
                dto.last_name(),
                dto.email(),
                dto.phone(),
                dto.password()
        );
    }

    @Override
    public UserDTO fromEntity(User entity) {
        return new UserDTO(
                entity.getId(),
                entity.getAddress(),
                entity.getRole(),
                entity.getImage(),
                entity.getOrders(),
                entity.getReviewList(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getPassword()
        );
    }
}
