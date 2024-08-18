package com.example.ecommerce;

import com.example.ecommerce.domain.dto.RoleDTO;
import com.example.ecommerce.service.RoleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoleServiceTest {

    @InjectMocks
    private RoleService roleService;

    @Test
    public void testRoleCreate(){
        RoleDTO newRole = new RoleDTO(null, "ADMIN", null);

        RoleDTO createdRole = this.roleService.create(newRole);

        assertEquals(newRole.displayName(), createdRole.displayName());
        assertEquals(newRole.userList(), createdRole.userList());

    }

    @Test
    public void testRoleUpdate(){
        RoleDTO newRole = new RoleDTO(null, "ADMIN", null);

        RoleDTO createdRole = this.roleService.create(newRole);

        RoleDTO updateRoleDTO = new RoleDTO(createdRole.id(), "USER", null);

        RoleDTO updatedRole = this.roleService.update(createdRole.id(), updateRoleDTO);

        assertEquals(updateRoleDTO.displayName(), updatedRole.displayName());
        assertEquals(updateRoleDTO.userList(), updatedRole.userList());
    }


}
