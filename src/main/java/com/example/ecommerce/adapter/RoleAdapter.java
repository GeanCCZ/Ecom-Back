package com.example.ecommerce.adapter;

import com.example.ecommerce.domain.dto.RoleDTO;
import com.example.ecommerce.domain.entities.Role;

public class RoleAdapter implements Adapter<Role, RoleDTO> {

    @Override
    public Role fromDto(RoleDTO dto) {
        return new Role(
                dto.display_name(),
                dto.user()
        );
    }

    @Override
    public RoleDTO fromEntity(Role entity) {
        return new RoleDTO(
                entity.getDisplayName(),
                entity.getUser()
        );
    }
}
