package com.example.ecommerce.adapters;

import com.example.ecommerce.domain.dto.RoleDTO;
import com.example.ecommerce.domain.dto.SupplierDTO;
import com.example.ecommerce.domain.entities.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleAdapter implements Adapter<Role, RoleDTO> {

    @Override
    public Role fromDto(RoleDTO dto) {
        return new Role(
                dto.displayName(),
                dto.userList()
        );
    }

    @Override
    public RoleDTO fromEntity(Role entity) {
        return new RoleDTO(
                entity.getId(),
                entity.getDisplayName(),
                entity.getUserList()
        );
    }
}
