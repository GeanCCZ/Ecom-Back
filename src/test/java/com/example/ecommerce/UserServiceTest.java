package com.example.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    void testUserCreate() {
        UserDTO newUser = new UserDTO(UUID.randomUUID(), null, null, null, null, null, "G.", "Son", " ", "(44) 911111111", "null", true, new Date());

        UserDTO createdUser = this.userService.create(newUser);

        assertEquals(newUser.firstName(), createdUser.firstName());
        assertEquals(newUser.lastName(), createdUser.lastName());
        assertEquals(newUser.email(), createdUser.email());
        assertEquals(newUser.phone(), createdUser.phone());
        assertEquals(newUser.password(), createdUser.password());
        assertEquals(newUser.role(), createdUser.role());
        assertEquals(newUser.addresses(), createdUser.addresses());
        assertEquals(newUser.orderList(), createdUser.orderList());
        assertEquals(newUser.reviewList(), createdUser.reviewList());
    }

    @Test
    void testUserUpdate() {
        UserDTO newUser = new UserDTO(UUID.randomUUID(), null, null, null, null, null, "G.", "Son", " ", "(44) 911111111", "null", null, null, null);

        UserDTO createdUser = this.userService.create(newUser);

        UserDTO updateUserDTO = new UserDTO(createdUser.id(), null, null, null, null, null, "G.", "Son", " ", "(44) 911111111", "null", null, null, null);

        UserDTO updatedUser = this.userService.update(createdUser.id(), updateUserDTO);

        assertEquals(updateUserDTO.firstName(), updatedUser.firstName());
        assertEquals(updateUserDTO.lastName(), updatedUser.lastName());
        assertEquals(updateUserDTO.email(), updatedUser.email());
        assertEquals(updateUserDTO.phone(), updatedUser.phone());
        assertEquals(updateUserDTO.password(), updatedUser.password());
        assertEquals(updateUserDTO.role(), updatedUser.role());
        assertEquals(updateUserDTO.addresses(), updatedUser.addresses());
        assertEquals(updateUserDTO.orderList(), updatedUser.orderList());
        assertEquals(updateUserDTO.reviewList(), updatedUser.reviewList());

    }
}
